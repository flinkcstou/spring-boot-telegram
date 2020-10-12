package kz.greetgo.cash_management_service.in_service.csd.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class InvestorTypeConstants {

  private static final Map<String, String> CONSTANTS = new HashMap<>();

  static {
    addConstants("Company Domestic   ~  17");

    addConstants("Company Foreign   ~ 18 ");
    addConstants("Individual Domestic  ~ 33");
    addConstants("Individual foreign  ~ 34 ");
  }

  private static void addConstants(String line) {
    String name = line.split("~")[0].trim();
    String decimal = line.split("~")[1].trim();

    CONSTANTS.put(decimal, name);
  }

  public static String getName(String decimal) {

    for (Entry<String, String> entry : CONSTANTS.entrySet()) {
      if (entry.getKey().equals(decimal.trim())) {
        return entry.getValue();
      }
    }
    throw new RuntimeException();
  }


}
