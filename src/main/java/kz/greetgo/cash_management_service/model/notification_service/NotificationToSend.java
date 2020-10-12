package kz.greetgo.cash_management_service.model.notification_service;

import java.util.List;
import kz.greetgo.cash_management_service.model.notification_service.enums.NotificationRoleEnum;
import kz.greetgo.cash_management_service.model.notification_service.enums.NotificationTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificationToSend {

  public Long notificationId;
  public NotificationTypeEnum type;
  public NotificationRoleEnum role;

  @Singular("phone")
  public List<String> phoneNumbers;

  @Singular("translate")
  public List<NotificationTranslateRecord> translates;

  public static NotificationToSend of(NotificationTypeEnum type, NotificationRoleEnum role,
                                      List<NotificationTranslateRecord> translates) {
    NotificationToSend toSend = new NotificationToSend();
    toSend.type = type;
    toSend.role = role;
    toSend.translates = translates;
    return toSend;
  }

}
