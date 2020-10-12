package kz.greetgo.cash_management_service.in_service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.function.Function;
import kz.greetgo.cash_management_service.model.Response;
import kz.greetgo.cash_management_service.util.ExceptionUtils;
import lombok.var;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.util.StringUtils;

public abstract class AbstractInService {

  private final OkHttpClient client;

  public AbstractInService(OkHttpClient client) {
    this.client = client;
  }

  protected Response<String> doRequest(Request request) {
    var response = new Response<String>();
    try {
      response.url = request.url().toString();
      try (var resp = client.newCall(request).execute()) {
        response.body = resp.body().string();
        response.isOk = resp.isSuccessful();
        response.status = resp.code();
        return response;
      }
    } catch (Exception e) {
      response.isOk = false;
      response.body = ExceptionUtils.stackTraceToString(e);
      response.status = 500;
      return response;
    }
  }

  protected String dateFormat(Date date) {
    return dateFormat(date, "yyyyMMdd");
  }

  protected String dateFormat(Date date, String format) {
    return new SimpleDateFormat(format).format(date);
  }

  protected void appendHeaderIfNotNull(Request.Builder urlBuilder, String name, String value) {
    if (!StringUtils.isEmpty(value)) {
      urlBuilder.header(name, value);
    }
  }

  protected <T> void appendIfNotNull(HttpUrl.Builder urlBuilder, String name, T value) {
    appendIfNotNull(urlBuilder, name, value, Objects::toString);
  }

  protected <T> void appendIfNotNull(HttpUrl.Builder urlBuilder, String name, T
    value, Function<T, String> converter) {
    if (Objects.nonNull(value)) {
      urlBuilder.addQueryParameter(name, converter.apply(value));
    }
  }

  protected <T> void appendIfNotNull(MultipartBody.Builder builder, String name, T value) {
    appendIfNotNull(builder, name, value, Objects::toString);
  }

  protected <T> void appendIfNotNull(MultipartBody.Builder builder, String name, T value,
                                     Function<T, String> converter) {
    if (Objects.nonNull(value)) {
      builder.addFormDataPart(name, converter.apply(value));
    }
  }

  public String toIsoDate(Date date) {
    SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd");
    return isoFormat.format(date);
  }

  protected MediaType JSON
    = MediaType.parse("application/json; charset=utf-8");

  protected MediaType TEXT
    = MediaType.parse("application/json; charset=utf-8");

}
