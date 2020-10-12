package kz.greetgo.cash_management_service.in_service.acs.fake;

import kz.greetgo.cash_management_service.in_service.acs.AcsInService;
import kz.greetgo.cash_management_service.in_service.acs.model.SessionResponse;
import kz.greetgo.cash_management_service.model.Response;


public class AcsInServiceFake implements AcsInService {
  
  @Override
  public Response<String> sessionCheck(String sessionId, String token) {
    return null;
  }

  @Override
  public Response<SessionResponse> sessionCheckAsObject(String sessionId, String token) {
    SessionResponse sessionResponse = new SessionResponse();
    sessionResponse.sessionId = "111";
    sessionResponse.token = "111";
    sessionResponse.appCode = "111";
    sessionResponse.personGuid = "111";
    sessionResponse.role = "BROKER";
    sessionResponse.roleName = "111";
    sessionResponse.displayName = "111";
    sessionResponse.username = "111";
    sessionResponse.errorMessage = "111";
    sessionResponse.status = 200;
    sessionResponse.error = null;
    sessionResponse.appKey = "111";
    return new Response<>("qwe", true, 200, sessionResponse);
  }

}
