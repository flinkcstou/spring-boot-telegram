package kz.greetgo.cash_management_service._preparation_;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import kz.greetgo.cash_management_service._preparation_.beans.Diff;

public class ShowDiff {

  public static void main(String[] args) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HHmmssSSS");

    try {

      new Diff().createDiff(new File("build/gen_sql/diff_"
                                         + sdf.format(new Date()) + ".sql"));
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
