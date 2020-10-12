package kz.greetgo.cash_management_service;

import kz.greetgo.cash_management_service.configuration.AuthenticationRegisterTest;
import kz.greetgo.cash_management_service.configuration.ScannerForTests;
import kz.greetgo.cash_management_service.configurations.BeanScannerWebConfig;
import kz.greetgo.cash_management_service.in_service.acs.AcsInService;
import kz.greetgo.cash_management_service.in_service.notification_service.NotificationServiceInService;
import kz.greetgo.cash_management_service.in_service.payment_middle_layer.PaymentMiddleLayerInService;
import kz.greetgo.cash_management_service.register.AuthenticationRegister;
import org.mockito.Mockito;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

@Configuration
@MapperScan(basePackages = {"kz.greetgo.cash_management_service.dao"})
@ComponentScan(basePackages = {"kz.greetgo.cash_management_service.configurations"},
  excludeFilters = {@Filter(type = FilterType.REGEX, pattern = ".*in_service_factories.*")})
@Import({BeanScannerWebConfig.class, JdbcTemplateAutoConfiguration.class, ScannerForTests.class})
public class TestConfiguration {

  @Primary
  @Bean
  public AuthenticationRegister authenticationRegister() {
    return new AuthenticationRegisterTest();
  }

  @Bean
  @Primary
  public AcsInService acsInService() {
    return Mockito.mock(AcsInService.class);
  }

  @Bean
  @Primary
  public NotificationServiceInService notificationServiceInService() {
    return Mockito.mock(NotificationServiceInService.class);
  }
  
  @Bean
  @Primary
  public PaymentMiddleLayerInService paymentMiddleLayerInService() {
    return Mockito.mock(PaymentMiddleLayerInService.class);
  }

}

