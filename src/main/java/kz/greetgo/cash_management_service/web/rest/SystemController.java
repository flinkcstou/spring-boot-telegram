package kz.greetgo.cash_management_service.web.rest;


import kz.greetgo.cash_management_service.Application;
import kz.greetgo.cash_management_service.in_service.acs.AcsInService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system")
@RequiredArgsConstructor
public class SystemController {
  
  @GetMapping(value = "/version")
  public ResponseEntity<String> version() {
    return ResponseEntity.ok(Application.class.getPackage().getSpecificationVersion());
  }

}
