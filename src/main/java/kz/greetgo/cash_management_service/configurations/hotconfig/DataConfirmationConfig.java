package kz.greetgo.cash_management_service.configurations.hotconfig;

import kz.greetgo.conf.hot.DefaultIntValue;
import kz.greetgo.conf.hot.DefaultStrValue;
import kz.greetgo.conf.hot.Description;
import kz.greetgo.conf.hot.FirstReadEnv;

@Description("Data confirmation config")
public interface DataConfirmationConfig {

  @Description("PUSH, SMS, EMAIL")
  @DefaultStrValue("PUSH")
  @FirstReadEnv("DATA_CONFIRMATION_TYPE")
  String confirmationType();

  @DefaultIntValue(120)
  @FirstReadEnv("DATA_CONFIRMATION_CODE_LIFE_TYPE")
  int codeLifetime();

}
