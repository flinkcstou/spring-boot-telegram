package kz.greetgo.cash_management_service.configuration;

import kz.greetgo.cash_management_service.in_service.acs.model.SessionResponse;
import kz.greetgo.cash_management_service.register.AuthenticationRegister;

public class AuthenticationRegisterTest implements AuthenticationRegister {

  public static final String TEST_SESSION = "TEST_SESSION";
  public static final String TEST_TOKEN = "TEST_TOKEN";
  public static final String TEST_USERNAME = "TEST_USER";

  @Override
  public SessionResponse getAuthData() {
    SessionResponse sessionResponse = new SessionResponse();
    sessionResponse.username = getUsername();
    sessionResponse.role = getRole();
    sessionResponse.sessionId = "TEST_SESSION";
    sessionResponse.token = "TEST_TOKEN";
    return sessionResponse;
  }

  @Override
  public String getUsername() {
    return TEST_USERNAME;
  }

  @Override
  public String getRole() {
    return "TEST";
  }

  @Override
  public boolean isAuthenticated() {
    return true;
  }

}
