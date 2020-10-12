package kz.greetgo.cash_management_service.configurations.nf36;

import static kz.greetgo.db.nf36.Nf36Builder.newNf36Builder;

import java.util.function.Supplier;
import kz.greetgo.db.DbType;
import kz.greetgo.db.Jdbc;
import kz.greetgo.db.nf36.core.Nf36Updater;

public class Nf36UpdaterBridge extends kz.greetgo.cash_management_service.nf36_gen.impl.AbstractDbUpdater {

  private Supplier<String> userName;
  private Jdbc jdbc;

  public Nf36UpdaterBridge(Jdbc jdbc, Supplier<String> userName) {
    this.jdbc = jdbc;
    this.userName = userName;
  }

  @Override
  protected Nf36Updater createUpdater() {
    return newNf36Builder()
      .updater()
      .database(DbType.Postgres)
      .setJdbc(jdbc)
      .build()
      .setAuthor(userName.get());
  }

}
