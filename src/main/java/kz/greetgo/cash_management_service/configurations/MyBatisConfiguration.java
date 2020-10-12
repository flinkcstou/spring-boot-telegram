package kz.greetgo.cash_management_service.configurations;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("kz.greetgo.cash_management_service.dao")
public class MyBatisConfiguration {
}
