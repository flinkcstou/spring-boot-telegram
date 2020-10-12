package kz.greetgo.cash_management_service.configurations.nf36;

import static kz.greetgo.db.nf36.Nf36Builder.newNf36Builder;

import java.util.function.Supplier;
import kz.greetgo.db.DbType;
import kz.greetgo.db.Jdbc;
import kz.greetgo.db.nf36.core.Nf36Saver;
import kz.greetgo.db.nf36.core.Nf36Upserter;
import kz.greetgo.db.nf36.core.SequenceNext;

public class Nf36UpserterBridge extends kz.greetgo.cash_management_service.nf36_gen.impl.AbstractDbUpserter {

  private Supplier<String> userName;
  private Jdbc jdbc;

  public Nf36UpserterBridge(Jdbc jdbc,
                            Supplier<String> userName) {
    this.jdbc = jdbc;
    this.userName = userName;
  }

  @Override
  protected Nf36Upserter createUpserter() {
    return newNf36Builder()
        .upserter()
        .database(DbType.Postgres)
        .setJdbc(jdbc)
        .build().setAuthor(userName.get());
  }

  @Override
  protected Nf36Saver createSaver() {
    return newNf36Builder().saver().setUpserter(createUpserter()).build();
  }

  @Override
  protected SequenceNext getSequenceNext() {
    return newNf36Builder()
        .sequenceNext()
        .database(DbType.Postgres)
        .setJdbc(jdbc)
        .build();
  }

}
