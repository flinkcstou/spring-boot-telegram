package kz.greetgo.cash_management_service.nf36_gen.impl;

import kz.greetgo.cash_management_service.nf36_gen.DbUpserter;
import kz.greetgo.db.nf36.core.Nf36Saver;
import kz.greetgo.db.nf36.core.Nf36Upserter;
import kz.greetgo.db.nf36.core.SequenceNext;

public abstract class AbstractDbUpserter implements DbUpserter {

  protected abstract Nf36Upserter createUpserter();

  protected abstract Nf36Saver createSaver();

  protected abstract SequenceNext getSequenceNext();

}
