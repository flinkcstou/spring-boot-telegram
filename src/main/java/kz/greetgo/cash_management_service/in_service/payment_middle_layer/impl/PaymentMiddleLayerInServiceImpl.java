package kz.greetgo.cash_management_service.in_service.payment_middle_layer.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import kz.greetgo.cash_management_service.in_service.AbstractInService;
import kz.greetgo.cash_management_service.in_service.payment_middle_layer.PaymentMiddleLayerInService;
import okhttp3.OkHttpClient;

public class PaymentMiddleLayerInServiceImpl extends AbstractInService implements PaymentMiddleLayerInService {

  private final String baseUrl;
  private final ObjectMapper mapper;

  public PaymentMiddleLayerInServiceImpl(String baseUrl, OkHttpClient client, ObjectMapper mapper) {
    super(client);
    this.baseUrl = baseUrl;
    this.mapper = mapper;
  }


}
