package kz.greetgo.cash_management_service.register;

import kz.greetgo.cash_management_service.in_service.acs.model.SessionResponse;

public interface AuthenticationRegister {

  SessionResponse getAuthData();

  String getUsername();

  String getRole();

  boolean isAuthenticated();

}
