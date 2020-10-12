package kz.greetgo.cash_management_service.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "UNAUTHORIZED")
public class UnauthorizedException extends RuntimeException {

  public UnauthorizedException() {
  }

  public UnauthorizedException(String message) {
    super(message);
  }

}
