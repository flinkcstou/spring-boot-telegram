package kz.greetgo.cash_management_service.web.rest.advice;


import com.fasterxml.jackson.databind.ObjectMapper;
import kz.greetgo.cash_management_service.model.exceptions.RestException;
import kz.greetgo.cash_management_service.model.exceptions.UnsupportedStageException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@RequiredArgsConstructor
public class RestApiAdvice {

  private final ObjectMapper mapper;

  @ExceptionHandler(RestException.class)
  public ResponseEntity<String> restRestException(RestException e) {
    return ResponseEntity.status(e.statusCode).body(e.getMessage());
  }

  @ExceptionHandler(UnsupportedStageException.class)
  public ResponseEntity<String> unsupportedStageException(UnsupportedStageException e) {
    return ResponseEntity.status(400).body(e.getMessage());
  }

}
