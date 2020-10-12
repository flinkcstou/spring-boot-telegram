package kz.greetgo.cash_management_service.in_service.notification_service;

import kz.greetgo.cash_management_service.model.notification_service.NotificationToSend;


public interface NotificationServiceInService {

  void schedule(NotificationToSend toSend);

}
