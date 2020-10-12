package kz.greetgo.cash_management_service.configurations.in_service_factories;

import com.fasterxml.jackson.databind.ObjectMapper;
import kz.greetgo.cash_management_service.configurations.hotconfig.AcsInServiceConfig;
import kz.greetgo.cash_management_service.in_service.acs.AcsInService;
import kz.greetgo.cash_management_service.in_service.acs.fake.AcsInServiceFake;
import kz.greetgo.cash_management_service.in_service.acs.impl.AcsInServiceImpl;
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
public class AcsInServiceFactory {

  private final AcsInServiceConfig config;
  private final AuthenticationRegister authenticationRegister;

  private final OkHttpClient okHttpClient;
  private final ObjectMapper mapper;

  @Bean
  @Primary
  @Scope(BeanDefinition.SCOPE_PROTOTYPE)
  public AcsInService acsInService() {
    if (config.useFake()) {
      return new AcsInServiceFake();
    } else {
      return new AcsInServiceImpl(config.acsApiURL(), okHttpClient, mapper, authenticationRegister);
    }
  }

}
