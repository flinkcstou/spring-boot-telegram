package kz.greetgo.cash_management_service.in_service.csd.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CsdAccount {

  public Long id;

  @JsonProperty("alias")
  public String alias;

  @JsonProperty("short")
  @JsonAlias("shortname")
  public String shortName;

  @JsonProperty("name")
  @JsonAlias("accountname")
  public String name;

  @JsonProperty("location")
  public String location;

  @JsonProperty("currency")
  public String currency;

  @JsonProperty("category")
  public String category;

  @JsonProperty("relation")
  public String relation;

}
