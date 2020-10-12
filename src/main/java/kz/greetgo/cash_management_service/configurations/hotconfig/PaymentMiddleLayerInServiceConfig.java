package kz.greetgo.cash_management_service.configurations.hotconfig;

import kz.greetgo.conf.hot.DefaultBoolValue;
import kz.greetgo.conf.hot.DefaultStrValue;
import kz.greetgo.conf.hot.Description;
import kz.greetgo.conf.hot.FirstReadEnv;

@Description("Parameter for integration with Payment Middle Layer REST API")
public interface PaymentMiddleLayerInServiceConfig {

  @Description("Base Payment Middle Layer REST API URL")
  @DefaultStrValue("http://0.0.0.0:8080/api")
  @FirstReadEnv("PAYMENT_MIDDLE_LAYER_SERVICE_URL")
  String base();

  @DefaultBoolValue(false)
  @FirstReadEnv("PAYMENT_MIDDLE_LAYER_SERVICE_FAKE")
  boolean useFake();

}
