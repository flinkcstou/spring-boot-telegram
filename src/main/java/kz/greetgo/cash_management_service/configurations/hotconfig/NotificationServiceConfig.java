package kz.greetgo.cash_management_service.configurations.hotconfig;

import kz.greetgo.conf.hot.DefaultBoolValue;
import kz.greetgo.conf.hot.DefaultStrValue;
import kz.greetgo.conf.hot.Description;
import kz.greetgo.conf.hot.FirstReadEnv;

@Description("Parameter for integration with Notification Service REST API")
public interface NotificationServiceConfig {

  @Description("Base Notification Service REST API URL")
  @DefaultStrValue("http://10.25.90.20:8080/api")
  @FirstReadEnv("NOTIFICATION_SERVICE_URL")
  String base();

  @DefaultBoolValue(false)
  @FirstReadEnv("NOTIFICATION_SERVICE_FAKE")
  boolean useFake();


}
