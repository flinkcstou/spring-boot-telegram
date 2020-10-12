package kz.greetgo.cash_management_service.model.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.SERVICE_UNAVAILABLE, reason = "Service Unavailable")
public class ServiceUnavailableException extends JsonRestException {

  public ServiceUnavailableException(String message) {
    super(503, message);
  }

}
