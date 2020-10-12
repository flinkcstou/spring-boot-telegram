package kz.greetgo.cash_management_service.in_service.fcb_service.impl;

import static kz.greetgo.cash_management_service.web.rest.filter.AuthFilter.GG_TOKEN;
import static kz.greetgo.cash_management_service.web.rest.filter.AuthFilter.SESSION_ID;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Objects;
import kz.greetgo.cash_management_service.in_service.AbstractInService;
import kz.greetgo.cash_management_service.in_service.fcb_service.FcbInService;
import kz.greetgo.cash_management_service.in_service.fcb_service.model.PreScoreInvestorRequest;
import kz.greetgo.cash_management_service.in_service.fcb_service.model.PreScoreInvestorResponse;
import kz.greetgo.cash_management_service.in_service.fcb_service.model.spouse.PreScoreSpouseRequest;
import kz.greetgo.cash_management_service.in_service.fcb_service.model.spouse.PreScoreSpouseResponse;
import kz.greetgo.cash_management_service.model.Response;
import kz.greetgo.cash_management_service.model.exceptions.RestException;
import lombok.SneakyThrows;
import lombok.var;
import okhttp3.HttpUrl;
import okhttp3.HttpUrl.Builder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class FcbInServiceImpl extends AbstractInService implements FcbInService {

  private final String baseUrl;
  private final ObjectMapper mapper;

  public FcbInServiceImpl(String baseUrl, OkHttpClient client, ObjectMapper mapper) {
    super(client);
    this.baseUrl = baseUrl;
    this.mapper = mapper;
  }

  @Override
  @SneakyThrows
  public PreScoreInvestorResponse getInvestorPreScore(
    PreScoreInvestorRequest preScoreInvestorRequest, String sessionId, String token) {
    HttpUrl.Builder builder = HttpUrl.get(baseUrl + "/v1/broker/investor/prescore").newBuilder();

    Response<String> response = getResponse(sessionId, token, builder,
                                            mapper.writeValueAsString(preScoreInvestorRequest));

    PreScoreInvestorResponse result = mapper
      .readValue(response.body, new TypeReference<PreScoreInvestorResponse>() {});

    if (Objects.nonNull(result.success) && !result.success) {
      throw new RestException(503, result.errorDescription);
    }

    return result;
  }

  @Override
  @SneakyThrows
  public PreScoreSpouseResponse getInvestorSpousePreScore(
    PreScoreSpouseRequest preScoreSpouseRequest, String sessionId, String token) {
    // TODO: 10/25/19 change spouce --> spouse in URL
    HttpUrl.Builder builder = HttpUrl.get(baseUrl + "/v1/broker/investor/spouce/prescore").newBuilder();

    Response<String> response = getResponse(sessionId, token, builder,
                                            mapper.writeValueAsString(preScoreSpouseRequest));

    PreScoreSpouseResponse result = mapper
      .readValue(response.body, new TypeReference<PreScoreSpouseResponse>() {});

    if (Objects.nonNull(result.success) && !result.success) {
      throw new RestException(503, result.errorDescription);
    }

    return result;
  }

  private Response<String> getResponse(String sessionId, String token, Builder builder, String value) {
    var request = new Request.Builder()
      .put(RequestBody.create(JSON, value))
      .url(builder.build());

    appendHeaderIfNotNull(request, SESSION_ID, sessionId);
    appendHeaderIfNotNull(request, GG_TOKEN, token);

    Response<String> response = doRequest(request.build());

    if (!response.isOk) {
      throw new RestException(503, response.body);
    }

    return response;
  }


}
