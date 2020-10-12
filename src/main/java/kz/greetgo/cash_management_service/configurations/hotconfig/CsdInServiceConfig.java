package kz.greetgo.cash_management_service.configurations.hotconfig;

import kz.greetgo.conf.hot.DefaultBoolValue;
import kz.greetgo.conf.hot.DefaultStrValue;
import kz.greetgo.conf.hot.Description;
import kz.greetgo.conf.hot.FirstReadEnv;

@Description("Parameter for integration with CSD REST API")
public interface CsdInServiceConfig {

  @Description("Base CSD REST API URL")
  @DefaultStrValue("http://0.0.0.0:8080/api")
  @FirstReadEnv("CSD_URL")
  String base();

  @DefaultBoolValue(false)
  @FirstReadEnv("CSD_SERVICE_FAKE")
  boolean useFake();

}
