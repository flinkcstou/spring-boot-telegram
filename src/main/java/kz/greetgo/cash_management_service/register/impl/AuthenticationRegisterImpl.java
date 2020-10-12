package kz.greetgo.cash_management_service.register.impl;

import kz.greetgo.cash_management_service.in_service.acs.model.SessionResponse;
import kz.greetgo.cash_management_service.register.AuthenticationRegister;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationRegisterImpl implements AuthenticationRegister {

  @Override
  public SessionResponse getAuthData() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication == null) {
      return null;
    }

    Object principal = authentication.getPrincipal();

    if (principal instanceof SessionResponse) {
      return (SessionResponse) principal;
    }

    return null;
  }

  @Override
  public String getUsername() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    if (authentication == null) {
      return null;
    }

    return authentication.getName();
  }

  @Override
  public String getRole() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    if (authentication == null) {
      return null;
    }

    return (String) authentication.getCredentials();
  }

  @Override
  public boolean isAuthenticated() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    return authentication == null || authentication.isAuthenticated();
  }

}
