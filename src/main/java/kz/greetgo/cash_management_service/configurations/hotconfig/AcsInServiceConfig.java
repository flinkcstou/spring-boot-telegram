package kz.greetgo.cash_management_service.configurations.hotconfig;

import kz.greetgo.conf.hot.DefaultBoolValue;
import kz.greetgo.conf.hot.DefaultStrValue;
import kz.greetgo.conf.hot.Description;
import kz.greetgo.conf.hot.FirstReadEnv;

@Description("Parameter for integration with ACS REST API")
public interface AcsInServiceConfig {

  @Description("Base ACS REST API URL")
  @DefaultStrValue("http://10.20.90.10:8080/acs")
  @FirstReadEnv("ACS_URL")
  String acsApiURL();

  @DefaultBoolValue(false)
  @FirstReadEnv("ACS_USE_FAKE")
  boolean useFake();

}
