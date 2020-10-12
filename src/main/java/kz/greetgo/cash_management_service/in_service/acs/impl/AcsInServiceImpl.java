package kz.greetgo.cash_management_service.in_service.acs.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import kz.greetgo.cash_management_service.in_service.AbstractInService;
import kz.greetgo.cash_management_service.in_service.acs.AcsInService;
import kz.greetgo.cash_management_service.in_service.acs.model.SessionResponse;
import kz.greetgo.cash_management_service.model.Response;
import kz.greetgo.cash_management_service.register.AuthenticationRegister;
import lombok.SneakyThrows;
import okhttp3.MultipartBody;
import okhttp3.MultipartBody.Builder;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class AcsInServiceImpl extends AbstractInService implements AcsInService {

  private final String baseUrl;
  private final ObjectMapper mapper;
  private AuthenticationRegister authRegister;


  public AcsInServiceImpl(String baseUrl, OkHttpClient client, ObjectMapper mapper,
                          AuthenticationRegister authRegister) {
    super(client);
    this.baseUrl = baseUrl;
    this.mapper = mapper;
    this.authRegister = authRegister;
  }


  @Override
  public Response<String> sessionCheck(String sessionId, String token) {
    Builder body = new Builder()
      .setType(MultipartBody.FORM)
      .addFormDataPart("sessionId", sessionId == null ? "null" : sessionId)
      .addFormDataPart("token", token == null ? "null" : token);

    Request.Builder builder = new Request.Builder()
      .url(baseUrl + "/rest/session/check.do")
      .post(body.build());

    return doRequest(builder.build());
  }

  @Override
  @SneakyThrows
  public Response<SessionResponse> sessionCheckAsObject(String sessionId, String token) {
    Response<String> response = sessionCheck(sessionId, token);

    Response<SessionResponse> objectResponse = new Response<>();
    objectResponse.status = response.status;
    objectResponse.url = response.url;
    objectResponse.isOk = response.isOk;

    if (response.isOk) {
      objectResponse.body = mapper.readValue(response.body, SessionResponse.class);
    }
    return objectResponse;
  }


}
