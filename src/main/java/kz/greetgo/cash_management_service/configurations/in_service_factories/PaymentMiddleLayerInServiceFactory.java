package kz.greetgo.cash_management_service.configurations.in_service_factories;

import com.fasterxml.jackson.databind.ObjectMapper;
import kz.greetgo.cash_management_service.configurations.hotconfig.PaymentMiddleLayerInServiceConfig;
import kz.greetgo.cash_management_service.in_service.payment_middle_layer.PaymentMiddleLayerInService;
import kz.greetgo.cash_management_service.in_service.payment_middle_layer.fake.PaymentMiddleLayerInServiceFake;
import kz.greetgo.cash_management_service.in_service.payment_middle_layer.impl.PaymentMiddleLayerInServiceImpl;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@RequiredArgsConstructor
public class PaymentMiddleLayerInServiceFactory {

  private final PaymentMiddleLayerInServiceConfig config;
  private final ObjectMapper mapper;
  private final OkHttpClient okHttpClient;

  @Bean
  @Scope(BeanDefinition.SCOPE_PROTOTYPE)
  public PaymentMiddleLayerInService paymentMiddleLayerInService() {
    if (config.useFake()) {
      return new PaymentMiddleLayerInServiceFake();
    } else {
      return new PaymentMiddleLayerInServiceImpl(config.base(), okHttpClient, mapper);
    }
  }

}
