package kz.greetgo.cash_management_service.model.notification_service;

import java.util.HashMap;
import java.util.Map;
import lombok.Data;

@Data
public abstract class AbstractNotificationTranslate {

  public Long notificationId;
  public String languageCode;

  public abstract String getText();

  public abstract String getTitle();

  public static Map<String, AbstractNotificationTranslate> getTranslateMap(
    Iterable<? extends AbstractNotificationTranslate> list) {
    HashMap<String, AbstractNotificationTranslate> translateMap = new HashMap<>();
    for (AbstractNotificationTranslate translate : list) {
      translateMap.put(translate.languageCode, translate);
    }
    return translateMap;
  }

}
