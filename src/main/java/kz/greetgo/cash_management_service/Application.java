package kz.greetgo.cash_management_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;

@SpringBootApplication(exclude = {
  JmxAutoConfiguration.class
})
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
