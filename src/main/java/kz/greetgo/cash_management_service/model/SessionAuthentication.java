package kz.greetgo.cash_management_service.model;

import com.google.common.collect.Lists;
import kz.greetgo.cash_management_service.in_service.acs.model.SessionResponse;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class SessionAuthentication extends AbstractAuthenticationToken {

  private final SessionResponse sessionResponse;
  
  public SessionAuthentication(SessionResponse sessionResponse) {
    super(
      Lists.newArrayList(new SimpleGrantedAuthority(sessionResponse.role != null ? sessionResponse.role : "NO ROLE")));
    super.setAuthenticated(true);
    super.setDetails(sessionResponse);
    this.sessionResponse = sessionResponse;
  }


  @Override
  public String getName() {
    return sessionResponse.username;
  }

  @Override
  public String getCredentials() {
    return sessionResponse.role;
  }

  @Override
  public Object getPrincipal() {
    return sessionResponse;
  }

  @Override
  public boolean isAuthenticated() {
    return (sessionResponse != null);
  }

  @Override
  public void setAuthenticated(boolean authenticated) {
    super.setAuthenticated(authenticated);
  }

}
