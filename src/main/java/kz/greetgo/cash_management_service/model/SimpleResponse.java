package kz.greetgo.cash_management_service.model;

public class SimpleResponse<T> {

  public final T response;


  public SimpleResponse(T response) {
    this.response = response;
  }

}
