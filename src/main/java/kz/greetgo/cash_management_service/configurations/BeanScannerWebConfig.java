package kz.greetgo.cash_management_service.configurations;

import kz.greetgo.cash_management_service.dao.BeanScannerDao;
import kz.greetgo.cash_management_service.register.impl.BeanScannerRegister;
import kz.greetgo.cash_management_service.web.rest.BeanScannerController;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({BeanScannerDao.class,
         BeanScannerRegister.class,
         BeanScannerController.class})
public class BeanScannerWebConfig {
}
