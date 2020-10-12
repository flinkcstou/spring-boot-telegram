package kz.greetgo.cash_management_service.configurations;

import javax.sql.DataSource;
import kz.greetgo.file_storage.FileStorage;
import kz.greetgo.file_storage.impl.FileStorageBuilder;
import kz.greetgo.cash_management_service.util.MimeTypeConfigurator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FileStorageFactory {

  private final DataSource dataSource;

  public FileStorageFactory(@Qualifier("FS") DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Bean
  public FileStorage create() {
    return FileStorageBuilder
      .newBuilder()
      .configureFrom(MimeTypeConfigurator.get())
      .mandatoryName(true)
      .mandatoryMimeType(true)
      .inDb(dataSource)
      .setParamsTableMimeTypeLength(450)
      .setParamsTableLastModifiedAt("last_modified_at")
      .setParamsTableMimeType("mime_type")
      .build();
  }

}
