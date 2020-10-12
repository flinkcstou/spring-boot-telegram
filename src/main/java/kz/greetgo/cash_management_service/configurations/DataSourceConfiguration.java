package kz.greetgo.cash_management_service.configurations;

import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import kz.greetgo.cash_management_service.configurations.hotconfig.DbConfig;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@RequiredArgsConstructor
@EnableTransactionManagement
public class DataSourceConfiguration {

  private final DbConfig dbConfig;

  @Bean
  @Primary
  public DataSource dataSource() {
    return getHikariDataSource();
  }

  @Bean("FS")
  public DataSource fileStorageDataSource() {
    return getHikariDataSource();
  }

  @Bean
  @Primary
  public JdbcTemplate jdbcTemplate() {
    return new JdbcTemplate(dataSource());
  }

  @Bean
  public SqlSessionFactory sqlSessionFactory() throws Exception {
    SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
    sessionFactory.setDataSource(dataSource());
    return sessionFactory.getObject();
  }

  private HikariDataSource getHikariDataSource() {
    HikariDataSource pool = new HikariDataSource();

    pool.setDriverClassName("org.postgresql.Driver");
    pool.setJdbcUrl(dbConfig.url());
    pool.setUsername(dbConfig.username());
    pool.setPassword(dbConfig.password());
    return pool;
  }

}
