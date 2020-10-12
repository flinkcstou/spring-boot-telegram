package kz.greetgo.cash_management_service.in_service.csd.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvestorToSave {

  @NotNull
  public String type;
  @NotNull
  public String name;
  @NotNull
  public String address1;
  @NotNull
  public String country;
  public String last;
  public String title;
  public String suffix;
  @DateTimeFormat(pattern = "YYYYMMDD")
  public Date dob;
  public String phone;
  public String mobile;
  public String email;
  public Integer idtype;
  public String idnumber;
  public String idcountry;
  @DateTimeFormat(pattern = "YYYYMMDD")
  public Date idexpiry;
  public String address2;
  public String address3;
  public String address4;
  public String address5;
  public String postcode;
  

}
