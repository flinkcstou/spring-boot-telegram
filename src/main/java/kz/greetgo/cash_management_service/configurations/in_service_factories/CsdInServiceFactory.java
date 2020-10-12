package kz.greetgo.cash_management_service.configurations.in_service_factories;

import com.fasterxml.jackson.databind.ObjectMapper;
import kz.greetgo.cash_management_service.configurations.hotconfig.CsdInServiceConfig;
import kz.greetgo.cash_management_service.in_service.csd.CsdInService;
import kz.greetgo.cash_management_service.in_service.csd.fake.CsdInServiceFake;
import kz.greetgo.cash_management_service.in_service.csd.impl.CsdInServiceImpl;
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
public class CsdInServiceFactory {

  private final CsdInServiceConfig config;
  private final AuthenticationRegister authenticationRegister;

  private final OkHttpClient okHttpClient;
  private final ObjectMapper mapper;

  @Bean
  @Primary
  @Scope(BeanDefinition.SCOPE_PROTOTYPE)
  public CsdInService csdInService() {
    if (config.useFake()) {
      return new CsdInServiceFake();
    } else {
      return new CsdInServiceImpl(config.base(), okHttpClient, mapper, authenticationRegister);
    }
  }

}
