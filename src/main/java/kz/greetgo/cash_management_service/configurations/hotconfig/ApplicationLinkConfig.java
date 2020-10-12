package kz.greetgo.cash_management_service.configurations.hotconfig;

import kz.greetgo.conf.hot.DefaultStrValue;
import kz.greetgo.conf.hot.Description;
import kz.greetgo.conf.hot.FirstReadEnv;

@Description("APPLICATION LINKS FOR DOWNLOAD")
public interface ApplicationLinkConfig {

  @Description("Base link to Play market")
  @DefaultStrValue("https://play.google.com/store/apps/details?id=kz.aix.connect")
  @FirstReadEnv("PLAY_MARKER_URL")
  String playMarket();

  @Description("Base link to App store")
  @DefaultStrValue("https://apps.apple.com/kz/app/aix-connect/id1468234819")
  @FirstReadEnv("APP_STORE_URL")
  String appStore();


}
