package kz.greetgo.cash_management_service.nf36_gen.impl;

import kz.greetgo.cash_management_service.nf36_gen.DbUpdater;
import kz.greetgo.db.nf36.core.Nf36Updater;

public abstract class AbstractDbUpdater implements DbUpdater {

  protected abstract Nf36Updater createUpdater();


}
