package kz.greetgo.cash_management_service.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Unsupported Stage")
public class UnsupportedStageException extends RuntimeException {

  public UnsupportedStageException() {
  }

  public UnsupportedStageException(String message) {
    super(message);
  }

}
