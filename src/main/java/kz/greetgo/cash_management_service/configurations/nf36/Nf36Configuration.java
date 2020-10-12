package kz.greetgo.cash_management_service.configurations.nf36;

import kz.greetgo.cash_management_service.nf36_gen.DbUpdater;
import kz.greetgo.cash_management_service.nf36_gen.DbUpserter;
import kz.greetgo.db.Jdbc;
import kz.greetgo.cash_management_service.register.AuthenticationRegister;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class Nf36Configuration {

  private final Jdbc jdbc;
  private final AuthenticationRegister authentication;

  @Bean
  public DbUpserter dbUpserter() {
    return new Nf36UpserterBridge(jdbc,
                                  authentication::getUsername);
  }

  @Bean
  public DbUpdater dbUpdater() {
    return new Nf36UpdaterBridge(jdbc,
                                 authentication::getUsername);
  }

}
