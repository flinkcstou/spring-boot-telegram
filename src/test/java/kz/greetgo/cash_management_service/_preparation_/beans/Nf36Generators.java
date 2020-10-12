package kz.greetgo.cash_management_service._preparation_.beans;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import kz.greetgo.db.nf36.gen.AuthorType;
import kz.greetgo.db.nf36.gen.DdlGenerator;
import kz.greetgo.db.nf36.gen.JavaGenerator;
import kz.greetgo.db.nf36.gen.ModelCollector;
import kz.greetgo.db.nf36.gen.SqlDialectPostgres;

public class Nf36Generators {

  private final Logger logger = Logger.getLogger(getClass().toString());

  private JavaGenerator javaGenerator;

  private ModelCollector collector;

  private DdlGenerator ddlGenerator;

  public void run() {
    collector = ModelCollector
        .newCollector()
        .setNf3Prefix(/*empty*/"")
        .setNf6Prefix("m.")
        .setNf6TableSeparator("_")
        .setNf6timeField("ts")
        .setNf3CreatedAtField("created_at")
        .setNf3ModifiedAtField("modified_at")
        .setAuthorFields("created_by", "modified_by", "inserted_by", AuthorType.STR, 32)
        .setMoreMethodName("more")
        .setCommitMethodName("commit")
        .setSequencePrefix("s_")
        .setIdLength(32)
        .setLongLength(2000)
        .setShortLength(50)
        .setDefaultLength(300)
        .setEnumLength(50);
    // TODO: 11/4/19
//        .scanPackageOfClassRecursively(OnBoarding.class, true);

    ddlGenerator = DdlGenerator.newGenerator(collector)
        .setSqlDialect(new SqlDialectPostgres())
        .setCommandSeparator(";;");
  }

  public void generateJava() {
    run();

    javaGenerator = JavaGenerator.newGenerator(collector)
        .setOutDir("src/nf36_gen")
        .setCleanOutDirsBeforeGeneration(true)
        .setInterfaceBasePackage("kz.greetgo.cash_management_service.nf36_gen.view")
        .setImplBasePackage("kz.greetgo.cash_management_service.nf36_gen.impl")
        .setUpdaterClassName("DbUpdater")
        .setUpserterClassName("DbUpserter")
        .setGenerateSaver(true)
        .setAbstracting(true);

    javaGenerator.generate();
  }


  List<String> generateSqlFilesAndGetText() throws Exception {
    run();
    List<File> sqlFileList = new ArrayList<>();
    {
      File outFile = new File("build/gen_sql/001_nf3_tables.sql");
      ddlGenerator.generateNf3Tables(outFile);
      sqlFileList.add(outFile);
      logger.info("Сгенерирован SQL file: " + outFile.getPath());
    }

    {
      File outFile = new File("build/gen_sql/002_nf6_tables.sql");
      ddlGenerator.generateNf6Tables(outFile);
      sqlFileList.add(outFile);
      logger.info("Сгенерирован SQL file: " + outFile.getPath());
    }

    {
      File outFile = new File("build/gen_sql/003_nf3_references.sql");
      ddlGenerator.generateNf3References(outFile);
      sqlFileList.add(outFile);
      logger.info("Сгенерирован SQL file: " + outFile.getPath());
    }

    {
      File outFile = new File("build/gen_sql/004_nf6_id_references.sql");
      ddlGenerator.generateNf6IdReferences(outFile);
      sqlFileList.add(outFile);
      logger.info("Сгенерирован SQL file: " + outFile.getPath());
    }
    {
      StringBuilder sb = new StringBuilder();
      sb.append("create schema  IF NOT EXISTS m;;\n");
      for (File file : sqlFileList) {
        appendToSB0(new FileInputStream(file), sb);
        sb.append(";;");
      }
      return Arrays.stream(sb.toString().split(";;"))
          .map(String::trim)
          .filter(s -> !s.isEmpty())
          .collect(Collectors.toList());
    }
  }

  public static void copyStreamsAndCloseIn(InputStream in, OutputStream out) {
    try {
      byte buffer[] = new byte[4096];

      while (true) {
        int read = in.read(buffer);
        if (read < 0) {
          break;
        }
        out.write(buffer, 0, read);
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally {
      try {
        in.close();
      } catch (IOException e) {
        //noinspection ThrowFromFinallyBlock
        throw new RuntimeException(e);
      }
    }
  }


  private static void appendToSB0(InputStream in, StringBuilder sb) throws IOException {
    ByteArrayOutputStream bout = new ByteArrayOutputStream();
    copyStreamsAndCloseIn(in, bout);
    sb.append(new String(bout.toByteArray(), "UTF-8"));
  }

}
