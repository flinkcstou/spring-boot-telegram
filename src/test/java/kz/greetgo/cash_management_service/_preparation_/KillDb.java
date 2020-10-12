package kz.greetgo.cash_management_service._preparation_;

import kz.greetgo.cash_management_service._preparation_.beans.DbWorker;

/**
 * <p>
 * see --> Удаление базы
 * </p>
 */
public class KillDb {

  public static void main(String[] args) throws Exception {
    new DbWorker().kill();
  }

}
