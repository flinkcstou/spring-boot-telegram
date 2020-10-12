package kz.greetgo.cash_management_service.model.notification_service;

import java.util.Arrays;
import java.util.Collection;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class NotificationTranslateRecord extends AbstractNotificationTranslate {

  public String title;
  public String text;

  public static Collection<NotificationTranslateRecord> confirmDataTranslates(String code) {
    return Arrays
      .asList(new NotificationTranslateRecord("AIX Mobile", code),
              new NotificationTranslateRecord("AIX Mobile", code),
              new NotificationTranslateRecord("AIX Mobile", code),
              new NotificationTranslateRecord("AIX Mobile", code));
  }

  public static Collection<NotificationTranslateRecord> translates(String text) {
    return Arrays
      .asList(new NotificationTranslateRecord("AIX Mobile", text),
              new NotificationTranslateRecord("AIX Mobile", text),
              new NotificationTranslateRecord("AIX Mobile", text),
              new NotificationTranslateRecord("AIX Mobile", text));
  }

}
