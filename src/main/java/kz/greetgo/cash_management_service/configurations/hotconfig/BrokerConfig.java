package kz.greetgo.cash_management_service.configurations.hotconfig;

import kz.greetgo.conf.hot.DefaultStrValue;
import kz.greetgo.conf.hot.Description;
import kz.greetgo.conf.hot.FirstReadEnv;

@Description("Broker Config")
public interface BrokerConfig {

  @DefaultStrValue("T21API")
  @FirstReadEnv("BROKER_ID")
  String brokerId();

}
