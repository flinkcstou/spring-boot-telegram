package kz.greetgo.cash_management_service.in_service.csd.impl;

import static kz.greetgo.cash_management_service.web.rest.filter.AuthFilter.GG_TOKEN;
import static kz.greetgo.cash_management_service.web.rest.filter.AuthFilter.SESSION_ID;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import kz.greetgo.cash_management_service.in_service.AbstractInService;
import kz.greetgo.cash_management_service.in_service.csd.CsdInService;
import kz.greetgo.cash_management_service.in_service.csd.model.CsdInvestor;
import kz.greetgo.cash_management_service.in_service.csd.model.InvestorToSave;
import kz.greetgo.cash_management_service.model.Response;
import kz.greetgo.cash_management_service.model.exceptions.RestException;
import kz.greetgo.cash_management_service.register.AuthenticationRegister;
import lombok.SneakyThrows;
import lombok.var;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class CsdInServiceImpl extends AbstractInService implements CsdInService {

  private final String baseUrl;
  private final ObjectMapper mapper;
  private final AuthenticationRegister authenticationRegister;

  public CsdInServiceImpl(String baseUrl, OkHttpClient client, ObjectMapper mapper,
                          AuthenticationRegister authenticationRegister) {
    super(client);
    this.baseUrl = baseUrl;
    this.mapper = mapper;
    this.authenticationRegister = authenticationRegister;
  }

  @Override
  @SneakyThrows
  public CsdInvestor saveInvestor(InvestorToSave investorToSave, String brokerId, String sessionId,
                                  String token) {
    HttpUrl.Builder builder = HttpUrl.get(baseUrl + "/v1/broker/investor/prescore").newBuilder();

    appendIfNotNull(builder, "brokerId", brokerId);

    var request = new Request.Builder()
      .post(RequestBody.create(JSON, mapper.writeValueAsString(investorToSave)))
      .url(builder.build());

    appendHeaderIfNotNull(request, SESSION_ID, sessionId);
    appendHeaderIfNotNull(request, GG_TOKEN, token);

    Response<String> response = doRequest(request.build());

    if (!response.isOk) {
      throw new RestException(503);
    }

    return mapper.readValue(response.body, new TypeReference<CsdInvestor>() {});
  }

}
