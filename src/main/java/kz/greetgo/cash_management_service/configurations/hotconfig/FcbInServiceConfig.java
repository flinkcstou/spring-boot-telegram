package kz.greetgo.cash_management_service.configurations.hotconfig;

import kz.greetgo.conf.hot.DefaultBoolValue;
import kz.greetgo.conf.hot.DefaultStrValue;
import kz.greetgo.conf.hot.Description;
import kz.greetgo.conf.hot.FirstReadEnv;

@Description("Parameter for integration with FCB REST API")
public interface FcbInServiceConfig {

  @Description("Base FCB REST API URL")
  @DefaultStrValue("http://0.0.0.0:8080/api")
  @FirstReadEnv("FIRST_CREDIT_BUREAU_SERVICE_URL")
  String base();

  @DefaultBoolValue(false)
  @FirstReadEnv("FIRST_CREDIT_BUREAU_SERVICE_FAKE")
  boolean useFake();

}
