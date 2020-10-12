package kz.greetgo.cash_management_service.model.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Bad request")
public class UserMessageException extends JsonRestException {

  public UserMessageException(String message) {
    super(400, message);
  }

}
