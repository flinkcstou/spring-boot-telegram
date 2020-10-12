package kz.greetgo.cash_management_service.model.notification_service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kz.greetgo.cash_management_service.model.notification_service.enums.NotificationRoleEnum;
import kz.greetgo.cash_management_service.model.notification_service.enums.NotificationTypeEnum;
import lombok.Data;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@ToString
public class NotificationToSave {

  public Long id;
  public Date publishDate;
  public String notificationTypeId;
  public NotificationTypeEnum type;
  public NotificationRoleEnum role;
  public String questionnaireCode;
  public String createdBy;

  public List<NotificationTranslateToSave> translates = new ArrayList<>();
  public List<UserNotificationData> usersToSend = new ArrayList<>();

}
