package kz.greetgo.cash_management_service.in_service.csd.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CsdContact {

  @JsonProperty("name")
  public String name;

  @JsonProperty("last")
  public String lastName;

  @JsonProperty("title")
  public String title;

  @JsonProperty("address1")
  public String address1;

  @JsonProperty("address2")
  public String address2;

  @JsonProperty("address3")
  public String address3;

  @JsonProperty("address4")
  public String address4;

  @JsonProperty("email")
  public String email;

  @JsonProperty("phone")
  public String phone;

  @JsonProperty("mobile")
  public String mobile;

  @JsonProperty("dob")
  @JsonFormat(pattern = "yyyyMMdd")
  public Date birthDate;

  @JsonProperty("idtype")
  public Long idType;

  @JsonProperty("idcountry")
  public String idCountry;

  @JsonProperty("iddate")
  @JsonFormat(pattern = "yyyyMMdd")
  public Date idDate;

  @JsonProperty("isprimary")
  public Boolean isPrimary;

  public Long id;

}
