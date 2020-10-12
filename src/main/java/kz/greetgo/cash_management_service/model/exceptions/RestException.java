package kz.greetgo.cash_management_service.model.exceptions;

/**
 * <p>
 * Генерируется при обработке запроса по REST.
 * </p>
 * <p>
 * Created by pompei on 2017-06-02.
 * </p>
 */
public class RestException extends RuntimeException {
  public final int statusCode;

  public RestException(int statusCode, String message) {
    super(message);
    this.statusCode = statusCode;
  }

  public RestException(int statusCode) {
    this(statusCode, null);
  }

  public RestException() {
    this(500, null);
  }

  public RestException(String message) {
    this(500, message);
  }
}
