package kz.greetgo.cash_management_service.util;

import java.nio.file.Path;
import java.nio.file.Paths;

public final class AppFolderPath {

  private static final String PROJECT_NAME = "cash_management_service";

  private AppFolderPath() {}

  private static Path appDir() {
    return Paths.get(System.getProperty("user.home"), String.format("/%s.d", PROJECT_NAME));
  }
  
  public static String confDir() {
    return appDir() + "/conf";
  }

}
