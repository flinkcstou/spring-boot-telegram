package kz.greetgo.cash_management_service._preparation_.beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;
import kz.greetgo.cash_management_service.configurations.hotconfig.DbConfig;
import kz.greetgo.cash_management_service.util.AppFolderPath;

public class DbParams {

  public String url;
  public String username;
  public String password;

  public String url() {
    return url;
  }

  public static DbParams withSuffix(DbParams source, String suffix) {
    DbParams result = new DbParams();

    result.url = source.url + suffix;
    result.username = source.username + suffix;
    result.password = source.password + suffix;

    return result;
  }

  public static DbParams readParams() throws IOException {
    Properties properties = new Properties();

    try (FileInputStream input = new FileInputStream(
        new File(AppFolderPath.confDir() + "/" + DbConfig.class.getSimpleName() + ".hotconfig"))) {
      properties.load(new InputStreamReader(input, Charset.forName("UTF-8")));

      DbParams ret = new DbParams();
      ret.username = properties.getProperty("username");
      ret.password = properties.getProperty("password");
      ret.url = properties.getProperty("url");
      return ret;
    }
  }

}
