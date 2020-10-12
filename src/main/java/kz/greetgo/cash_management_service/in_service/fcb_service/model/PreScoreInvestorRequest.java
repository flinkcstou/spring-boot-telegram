package kz.greetgo.cash_management_service.in_service.fcb_service.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PreScoreInvestorRequest {

  public String name;
  public String surname;
  public String middlename;
  public Boolean resident;
  public String iin;
  public String email;
  public String brokerId;
  @JsonIgnore
  public String shortCode;
  public String idNumber;
  public String idIssuedBy;
  @JsonFormat(shape = JsonFormat.Shape.NUMBER)
  public Date idIssuedDate;
  @JsonFormat(shape = JsonFormat.Shape.NUMBER)
  public Date idValidDate;
  public String country;
  public String city;
  public String address;
  public String married;
  @JsonFormat(pattern = "dd.mm.yyyy")
  public Date dob;
  public String investorCategory;
  public String phone;

  @JsonSetter("short")
  public void setShortCode(String shortCode) {
    this.shortCode = shortCode;
  }

}
