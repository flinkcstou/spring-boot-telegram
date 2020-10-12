package kz.greetgo.cash_management_service.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Ошибка запроса по REST которая ещё отправляет объект через JSON.
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Bad request")
public class JsonRestException extends RestException {

  public final Object sendingAsJsonObject;

  public JsonRestException(Object sendingAsJsonObject) {
    super(sendingAsJsonObject == null ? null : sendingAsJsonObject.toString());
    this.sendingAsJsonObject = sendingAsJsonObject;
  }

  public JsonRestException(int statusCode, Object sendingAsJsonObject) {
    super(statusCode, sendingAsJsonObject == null ? null : sendingAsJsonObject.toString());
    this.sendingAsJsonObject = sendingAsJsonObject;
  }

}
