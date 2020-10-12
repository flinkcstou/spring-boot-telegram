package kz.greetgo.cash_management_service.model.notification_service;

import lombok.ToString;

@ToString
public class NotificationTranslateToSave {

  public Long notificationId;
  public String languageCode;
  public String title;
  public String text;

}
