package kz.greetgo.cash_management_service.util.db;

import java.sql.SQLException;
import kz.greetgo.db.ConnectionCallback;
import kz.greetgo.db.Jdbc;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class GreetgoJdbcTemplateAdapter implements Jdbc {

  private final JdbcTemplate jdbcTemplate;

  public GreetgoJdbcTemplateAdapter(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}


  @Override
  public <T> T execute(ConnectionCallback<T> connectionCallback) {
    return jdbcTemplate.execute((org.springframework.jdbc.core.ConnectionCallback<T>) con -> {
      try {
        return connectionCallback.doInConnection(con);
      } catch (SQLException | DataAccessException e) {
        throw e;
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    });
  }

}
