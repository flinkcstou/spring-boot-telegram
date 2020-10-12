package kz.greetgo.cash_management_service.model.notification_service.enums;

import java.util.ArrayList;
import java.util.List;
import kz.greetgo.cash_management_service.model.SimpleRecord;

public enum NotificationStatusEnum {
  DRAFT, PLANNED, PUBLISHING, PUBLISHED;

  public static NotificationStatusEnum parseOrNull(String status) {
    try {
      return NotificationStatusEnum.valueOf(status);
    } catch (Exception e) {
      return null;
    }
  }

  public static List<SimpleRecord> getListSimple() {
    ArrayList<SimpleRecord> list = new ArrayList<>();
    for (NotificationStatusEnum status : NotificationStatusEnum.values()) {
      list.add(SimpleRecord.of(status.name(), status.name()));
    }
    return list;
  }

}
