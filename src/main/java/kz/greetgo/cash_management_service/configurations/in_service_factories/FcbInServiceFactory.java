package kz.greetgo.cash_management_service.configurations.in_service_factories;

import com.fasterxml.jackson.databind.ObjectMapper;
import kz.greetgo.cash_management_service.configurations.hotconfig.FcbInServiceConfig;
import kz.greetgo.cash_management_service.in_service.fcb_service.FcbInService;
import kz.greetgo.cash_management_service.in_service.fcb_service.fake.FcbInServiceFake;
import kz.greetgo.cash_management_service.in_service.fcb_service.impl.FcbInServiceImpl;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@RequiredArgsConstructor
public class FcbInServiceFactory {

  private final FcbInServiceConfig config;
  private final ObjectMapper mapper;
  private final OkHttpClient okHttpClient;

  @Bean
  @Scope(BeanDefinition.SCOPE_PROTOTYPE)
  public FcbInService fcbInService() {
    if (config.useFake()) {
      return new FcbInServiceFake();
    } else {
      return new FcbInServiceImpl(config.base(), okHttpClient, mapper);
    }
  }

}
