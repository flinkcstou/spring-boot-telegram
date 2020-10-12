package kz.greetgo.cash_management_service.in_service.csd.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CsdInvestor {

  public Long id;

  public String nin;

  @JsonProperty("name")
  public String name;

  @JsonProperty("short")
  public String shortName;

  @JsonProperty("preferred")
  public String preferred;

  @JsonProperty("address1")
  public String address1;

  @JsonProperty("address2")
  public String address2;

  @JsonProperty("address3")
  public String address3;

  @JsonProperty("address4")
  public String address4;

  @JsonProperty("country")
  public String country;

  @JsonProperty("email")
  public String email;

  @JsonProperty("phone")
  public String phone;

  @JsonProperty("mobile")
  public String mobile;

  @JsonProperty("contacts")
  public List<CsdContact> contacts = new ArrayList<>();

  @JsonProperty("accounts")
  public List<CsdAccount> accounts = new ArrayList<>();

  public void calculateNin() {
    accounts.stream()
      .filter(csdAccount -> csdAccount.alias != null && csdAccount.alias.contains("-"))
      .findAny().ifPresent(csdAccount -> this.nin = csdAccount.alias.split("-")[1]);
  }

}
