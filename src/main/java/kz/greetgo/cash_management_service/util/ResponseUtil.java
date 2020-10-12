package kz.greetgo.cash_management_service.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.function.Supplier;
import okhttp3.MultipartBody;

public class ResponseUtil {

  public static MultipartBody.Builder copySameFields(Supplier<?> data,
                                                     ObjectMapper objectMapper) {
    try {
      MultipartBody.Builder builder = new MultipartBody.Builder();
      builder.setType(MultipartBody.FORM);

      Object dataObj = data.get();
      for (Field retField : dataObj.getClass().getFields()) {

        String fieldName = retField.getName();
        Field field;
        try {
          field = dataObj.getClass().getField(fieldName);
        } catch (NoSuchFieldException e) {
          continue;
        }

        if (field != null) {
          Object value = field.get(dataObj);
          if (value != null) {

            if (field.getType().isEnum()) {
              builder.addFormDataPart(fieldName, ((Enum) value).name());
            } else if (Collection.class.isAssignableFrom(field.getType())) {
              objectMapper.configure(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS, false);
              builder.addFormDataPart(fieldName, objectMapper.writeValueAsString(field.getType().cast(value)));
            } else {
              builder.addFormDataPart(fieldName, String.valueOf(value));
            }
          }
        }
      }
      return builder;
    } catch (IllegalAccessException | JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

}
