package kz.greetgo.cash_management_service._preparation_.beans;

import java.io.File;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import kz.greetgo.libase.changes.AlterField;
import kz.greetgo.libase.changes.Change;
import kz.greetgo.libase.changes.Comparer;
import kz.greetgo.libase.changes.CreateRelation;
import kz.greetgo.libase.changesql.SqlGeneratorPostgres;
import kz.greetgo.libase.model.DbStru;
import kz.greetgo.libase.strureader.RowReaderPostgres;
import kz.greetgo.libase.strureader.StruReader;

public class Diff extends DbWorker {

  public void createDiff(File outFile) throws Exception {
    prepareDatabasesForDiff();

    DbStru from, to;

    System.out.println("Чтение структуры MAIN DB DIFF");
    DbParams dbParams = DbParams.readParams();
    DbParams diff = DbParams.withSuffix(dbParams, "_diff");
    try (Connection con = getConnection(diff)) {
      from = StruReader.read(new RowReaderPostgres(con).addSchema("m"));
    }
    System.out.println("Чтение структуры MAIN DB");
    try (Connection con = getConnection(dbParams)) {
      to = StruReader.read(new RowReaderPostgres(con).addSchema("m"));
    }

    printDiffFile(outFile, from, to);
  }

  private void printDiffFile(File outFile, DbStru from, DbStru to) throws Exception {
    System.out.println("Сравнение структур");
    List<Change> changesAll = Comparer.compare(to, from).stream()
        .filter(c -> !(c instanceof AlterField))
        .filter(c -> {
          if (!(c instanceof CreateRelation)) {
            return true;
          }
          CreateRelation cr = (CreateRelation) c;
          return !cr.relation.name.startsWith("databaseChangeLog".toLowerCase());
        })
        .collect(Collectors.toList());

    SqlGeneratorPostgres g = new SqlGeneratorPostgres();

    List<String> sqlResult = new ArrayList<>();
    g.generate(sqlResult, changesAll);

    System.out.println("Разница БД выведена в файл: " + outFile.getPath());
    try (PrintStream out = new PrintStream(outFile, "UTF-8")) {
      sqlResult.stream().map(sql -> sql + ";;").forEach(out::println);
    }
  }

  private void prepareDatabasesForDiff() throws Exception {
    DbParams dbParams = DbParams.readParams();
    DbParams diff = DbParams.withSuffix(dbParams, "_diff");

    System.out.println("Накат liquibase на MAIN DB");
    killDb(dbParams);
    createDb(dbParams);
    runLiquibase(dbParams);

    System.out.println("Накат текущей структуры на MAIN DB DIFF");

    killDb(diff);
    createDb(diff);
    try (Connection con = getConnection(diff)) {
      Nf36Generators nf36Generators = new Nf36Generators();
      for (String sql : nf36Generators.generateSqlFilesAndGetText()) {
        execSql(con, sql);
      }
    }
  }

  private void execSql(Connection con, String sql) throws SQLException {
    try (Statement stt = con.createStatement()) {
      System.out.println("EXEC SQL: " + sql);
      stt.executeUpdate(sql);
    }
  }

}
