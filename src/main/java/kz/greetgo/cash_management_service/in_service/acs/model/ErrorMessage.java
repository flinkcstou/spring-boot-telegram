package kz.greetgo.cash_management_service.in_service.acs.model;

import lombok.ToString;

@ToString
public class ErrorMessage {

  public String id;
  public String code;
  public String message;

  public static ErrorMessage of(String id, String code, String message) {
    ErrorMessage error = new ErrorMessage();
    error.id = id;
    error.code = code;
    error.message = message;
    return error;
  }

}
