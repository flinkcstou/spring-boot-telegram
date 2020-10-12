package kz.greetgo.cash_management_service.configurations.in_service_factories;

import com.fasterxml.jackson.databind.ObjectMapper;
import kz.greetgo.cash_management_service.configurations.hotconfig.NotificationServiceConfig;
import kz.greetgo.cash_management_service.in_service.notification_service.NotificationServiceInService;
import kz.greetgo.cash_management_service.in_service.notification_service.fake.NotificationServiceInServiceFake;
import kz.greetgo.cash_management_service.in_service.notification_service.impl.NotificationServiceInServiceImpl;
import kz.greetgo.cash_management_service.register.AuthenticationRegister;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
@RequiredArgsConstructor
public class NotificationServiceInServiceFactory {

  private final OkHttpClient okHttpClient;
  private final NotificationServiceConfig config;
  private final ObjectMapper objectMapper;
  private final AuthenticationRegister authRegister;

  @Bean
  @Primary
  @Scope(BeanDefinition.SCOPE_PROTOTYPE)
  public NotificationServiceInService notificationServiceInService() {
    if (config.useFake()) {
      return new NotificationServiceInServiceFake(okHttpClient, objectMapper);
    }
    return new NotificationServiceInServiceImpl(okHttpClient, config.base(), objectMapper, authRegister);
  }

}