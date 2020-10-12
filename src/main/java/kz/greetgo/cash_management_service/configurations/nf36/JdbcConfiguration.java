package kz.greetgo.cash_management_service.configurations.nf36;

import javax.sql.DataSource;
import kz.greetgo.db.Jdbc;
import kz.greetgo.cash_management_service.util.db.GreetgoJdbcTemplateAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@RequiredArgsConstructor
public class JdbcConfiguration {

  private final DataSource dataSource;
  private final JdbcTemplate jdbcTemplate;

  @Bean
  public DataSourceTransactionManager txManager() {
    return new DataSourceTransactionManager(dataSource);
  }


  @Bean
  public Jdbc jdbc() {
    return new GreetgoJdbcTemplateAdapter(jdbcTemplate);
  }

}
