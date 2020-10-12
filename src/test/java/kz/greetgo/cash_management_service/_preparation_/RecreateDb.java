package kz.greetgo.cash_management_service._preparation_;


import kz.greetgo.cash_management_service._preparation_.beans.DbWorker;

public class RecreateDb {

  public static void main(String[] args) throws Exception {
    new DbWorker().recreate();
  }

}
