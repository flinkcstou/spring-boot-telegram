package kz.greetgo.cash_management_service.configurations.security;

import kz.greetgo.cash_management_service.in_service.acs.AcsInService;
import kz.greetgo.cash_management_service.web.rest.filter.AuthFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@Order(1)
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {

  private final AcsInService acsInService;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.sessionManagement()
      .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
      .and()
      .requestMatchers()
      .antMatchers("/system/**")
      .and()
      .addFilterBefore(new AuthFilter(acsInService), BasicAuthenticationFilter.class)
      .authorizeRequests().anyRequest().permitAll()
      .and().csrf().disable();
  }

  @Override
  public void configure(WebSecurity web) {
    web.ignoring().antMatchers(HttpMethod.OPTIONS);
  }

}
