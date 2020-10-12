package kz.greetgo.cash_management_service.in_service.acs;

import kz.greetgo.cash_management_service.in_service.acs.model.SessionResponse;
import kz.greetgo.cash_management_service.model.Response;

public interface AcsInService {

  Response<String> sessionCheck(String sessionId, String token);

  Response<SessionResponse> sessionCheckAsObject(String sessionId, String token);

}
