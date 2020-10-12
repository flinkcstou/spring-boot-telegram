package kz.greetgo.cash_management_service.web.rest.filter;

import com.google.common.base.Strings;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kz.greetgo.cash_management_service.in_service.acs.AcsInService;
import kz.greetgo.cash_management_service.in_service.acs.model.SessionResponse;
import kz.greetgo.cash_management_service.model.Response;
import kz.greetgo.cash_management_service.model.SessionAuthentication;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

@RequiredArgsConstructor
public class AuthFilter implements Filter {

  private final AcsInService acsInService;

  public static final String SESSION_ID = "session_id";
  public static final String GG_TOKEN = "gg_token";

  @Override
  @SneakyThrows
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpServletResponse httpResponse = (HttpServletResponse) response;

    String sessionId = httpRequest.getHeader(SESSION_ID);
    String ggToken = httpRequest.getHeader(GG_TOKEN);

    if (!Strings.isNullOrEmpty(sessionId) && !Strings.isNullOrEmpty(ggToken)) {
      Response<SessionResponse> sessionResponse = acsInService.sessionCheckAsObject(sessionId, ggToken);
      if (!sessionResponse.isOk || sessionResponse.status != 200) {

        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        httpResponse.setContentType("application/json");

        httpResponse.getWriter().write("no_session");
        return;
      }
      SessionAuthentication authReq = new SessionAuthentication(sessionResponse.body);
      SecurityContext sc = SecurityContextHolder.getContext();
      sc.setAuthentication(authReq);

      chain.doFilter(request, response);
      return;
    }

    httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    httpResponse.setContentType("application/json");

    httpResponse.getWriter().write("no_session");
    return;
  }

}
