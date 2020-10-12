package kz.greetgo.cash_management_service.model.notification_service.enums;

import java.util.ArrayList;
import java.util.List;
import kz.greetgo.cash_management_service.model.SimpleRecord;

public enum NotificationTypeEnum {
  PUSH, SMS, EMAIL;

  public static NotificationTypeEnum parseOrNull(String type) {
    try {
      return NotificationTypeEnum.valueOf(type);
    } catch (Exception e) {
      return null;
    }
  }

  public static NotificationTypeEnum parseOrDefault(String type, NotificationTypeEnum def) {
    try {
      return NotificationTypeEnum.valueOf(type);
    } catch (Exception e) {
      return def;
    }
  }

  public static List<SimpleRecord> getListSimple() {
    ArrayList<SimpleRecord> list = new ArrayList<>();
    for (NotificationTypeEnum type : NotificationTypeEnum.values()) {
      list.add(SimpleRecord.of(type.name(), type.name()));
    }
    return list;
  }

}
