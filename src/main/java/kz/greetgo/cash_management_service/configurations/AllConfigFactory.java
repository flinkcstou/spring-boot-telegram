package kz.greetgo.cash_management_service.configurations;


import java.nio.file.Path;
import java.nio.file.Paths;
import kz.greetgo.conf.hot.FileConfigFactory;
import kz.greetgo.conf.spring.cloud.hot.CloudFileConfigFactory;
import kz.greetgo.cash_management_service.configurations.hotconfig.AcsInServiceConfig;
import kz.greetgo.cash_management_service.configurations.hotconfig.ApplicationLinkConfig;
import kz.greetgo.cash_management_service.configurations.hotconfig.BrokerConfig;
import kz.greetgo.cash_management_service.configurations.hotconfig.CsdInServiceConfig;
import kz.greetgo.cash_management_service.configurations.hotconfig.DataConfirmationConfig;
import kz.greetgo.cash_management_service.configurations.hotconfig.DbConfig;
import kz.greetgo.cash_management_service.configurations.hotconfig.FcbInServiceConfig;
import kz.greetgo.cash_management_service.configurations.hotconfig.FileConfig;
import kz.greetgo.cash_management_service.configurations.hotconfig.NotificationServiceConfig;
import kz.greetgo.cash_management_service.configurations.hotconfig.PaymentMiddleLayerInServiceConfig;
import kz.greetgo.cash_management_service.util.AppFolderPath;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AllConfigFactory extends FileConfigFactory {

  @Override
  protected Path getBaseDir() {
    return Paths.get(AppFolderPath.confDir());
  }

  @Bean
  public DbConfig createPostgresDbConfig() {
    return createConfig(DbConfig.class);
  }

  @Bean
  public FileConfig createFileConfig() {
    return createConfig(FileConfig.class);
  }

  @Bean
  public AcsInServiceConfig acsInServiceConfig() {
    return createConfig(AcsInServiceConfig.class);
  }

  @Bean
  public NotificationServiceConfig notificationServiceConfig() {
    return createConfig(NotificationServiceConfig.class);
  }

  @Bean
  public PaymentMiddleLayerInServiceConfig paymentMiddleLayerConfig() {
    return createConfig(PaymentMiddleLayerInServiceConfig.class);
  }

  @Bean
  public FcbInServiceConfig fcbInServiceConfig() {
    return createConfig(FcbInServiceConfig.class);
  }

  @Bean
  public DataConfirmationConfig dataConfirmationConfig() {
    return createConfig(DataConfirmationConfig.class);
  }

  @Bean
  public ApplicationLinkConfig applicationLinkConfig() {
    return createConfig(ApplicationLinkConfig.class);
  }

  @Bean
  public CsdInServiceConfig csdInServiceConfig() {
    return createConfig(CsdInServiceConfig.class);
  }

  @Bean
  public BrokerConfig brokerConfig() {
    return createConfig(BrokerConfig.class);
  }

}
