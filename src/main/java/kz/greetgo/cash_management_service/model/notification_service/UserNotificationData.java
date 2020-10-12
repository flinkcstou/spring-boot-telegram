package kz.greetgo.cash_management_service.model.notification_service;

import kz.greetgo.cash_management_service.model.notification_service.enums.NotificationRoleEnum;
import lombok.ToString;

@ToString
public class UserNotificationData {

  public String fio;
  public String phoneNumber;
  public String email;
  public String pushToken;
  public String languageCode;
  public NotificationRoleEnum role;

}
