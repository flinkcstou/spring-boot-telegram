package kz.greetgo.cash_management_service.model.notification_service.enums;


import java.util.ArrayList;
import java.util.List;
import kz.greetgo.cash_management_service.model.SimpleRecord;

public enum NotificationRoleEnum {
  BROKER, INVESTOR, GUEST, NONE, ALL;

  public static NotificationRoleEnum parseOrNull(String role) {
    try {
      return NotificationRoleEnum.valueOf(role);
    } catch (Exception e) {
      return null;
    }
  }

  public static NotificationRoleEnum parseOrALL(String role) {
    try {
      return NotificationRoleEnum.valueOf(role);
    } catch (Exception e) {
      return ALL;
    }
  }

  public static List<SimpleRecord> getListSimple() {
    ArrayList<SimpleRecord> list = new ArrayList<>();
    for (NotificationRoleEnum role : NotificationRoleEnum.values()) {
      list.add(SimpleRecord.of(role.name(), role.name()));
    }
    return list;
  }

}
