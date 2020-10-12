package kz.greetgo.cash_management_service.configurations.hotconfig;

import kz.greetgo.conf.hot.DefaultIntValue;
import kz.greetgo.conf.hot.Description;
import kz.greetgo.conf.hot.FirstReadEnv;

@Description("Настройки для работы с файлами")
public interface FileConfig {

  @Description("Максимальный размер загружаемого файла (байты)")
  @DefaultIntValue(70242880)
  @FirstReadEnv("MAX_FILE_SIZE")
  int getMaximumFileSize();

}
