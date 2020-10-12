package kz.greetgo.cash_management_service.configurations.hotconfig;

import kz.greetgo.conf.hot.DefaultStrValue;
import kz.greetgo.conf.hot.Description;
import kz.greetgo.conf.hot.FirstReadEnv;

@Description("Параметры доступа к БД (используется только БД Postgresql)")
public interface DbConfig {

  @Description("URL доступа к БД")
  @DefaultStrValue("jdbc:postgresql://localhost:5432/cash_management_service")
  @FirstReadEnv("DATABASE_URL")
  String url();

  @Description("Пользователь для доступа к БД")
  @DefaultStrValue("cash_management_service")
  @FirstReadEnv("DATABASE_USER")
  String username();

  @Description("Пароль для доступа к БД")
  @DefaultStrValue("cash_management_service")
  @FirstReadEnv("DATABASE_PASSWORD")
  String password();

}
