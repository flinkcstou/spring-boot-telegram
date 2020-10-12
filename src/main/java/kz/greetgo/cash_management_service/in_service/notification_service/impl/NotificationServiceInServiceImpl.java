package kz.greetgo.cash_management_service.in_service.notification_service.impl;

import static kz.greetgo.cash_management_service.web.rest.filter.AuthFilter.GG_TOKEN;
import static kz.greetgo.cash_management_service.web.rest.filter.AuthFilter.SESSION_ID;

import com.fasterxml.jackson.databind.ObjectMapper;
import kz.greetgo.cash_management_service.in_service.AbstractInService;
import kz.greetgo.cash_management_service.in_service.acs.model.SessionResponse;
import kz.greetgo.cash_management_service.in_service.notification_service.NotificationServiceInService;
import kz.greetgo.cash_management_service.model.Response;
import kz.greetgo.cash_management_service.model.exceptions.RestException;
import kz.greetgo.cash_management_service.model.notification_service.NotificationToSend;
import kz.greetgo.cash_management_service.register.AuthenticationRegister;
import kz.greetgo.cash_management_service.util.ResponseUtil;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class NotificationServiceInServiceImpl extends AbstractInService implements NotificationServiceInService {

  private final String baseUrl;
  private final ObjectMapper objectMapper;
  private final AuthenticationRegister authRegister;

  public NotificationServiceInServiceImpl(OkHttpClient client, String baseUrl,
                                          ObjectMapper objectMapper, AuthenticationRegister authRegister) {
    super(client);
    this.baseUrl = baseUrl;
    this.objectMapper = objectMapper;
    this.authRegister = authRegister;
  }

  @Override
  public void schedule(NotificationToSend toSend) {
    MultipartBody.Builder builder = ResponseUtil.copySameFields(() -> toSend, objectMapper);
    Request.Builder request = new Request.Builder()
      .url(baseUrl + "/notification/schedule")
      .post(builder.build());

    SessionResponse authData = authRegister.getAuthData();

    appendHeaderIfNotNull(request, SESSION_ID, authData.sessionId);
    appendHeaderIfNotNull(request, GG_TOKEN, authData.token);

    Response<String> response = doRequest(request.build());
    if (!response.isOk) {
      throw new RestException(response.status, response.body);
    }
  }

}