package kz.greetgo.cash_management_service.in_service.notification_service.fake;

import com.fasterxml.jackson.databind.ObjectMapper;
import kz.greetgo.cash_management_service.in_service.AbstractInService;
import kz.greetgo.cash_management_service.in_service.notification_service.NotificationServiceInService;
import kz.greetgo.cash_management_service.model.notification_service.NotificationToSend;
import okhttp3.OkHttpClient;

public class NotificationServiceInServiceFake extends AbstractInService implements NotificationServiceInService {

  private final ObjectMapper objectMapper;

  public NotificationServiceInServiceFake(OkHttpClient client, ObjectMapper objectMapper) {
    super(client);
    this.objectMapper = objectMapper;
  }

  @Override
  public void schedule(NotificationToSend toSend) {
    return;
  }

}
