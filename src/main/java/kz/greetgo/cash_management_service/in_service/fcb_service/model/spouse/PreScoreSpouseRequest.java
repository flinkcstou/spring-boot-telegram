package kz.greetgo.cash_management_service.in_service.fcb_service.model.spouse;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class PreScoreSpouseRequest {

  public String name;
  public String surname;
  public String middlename;
  public String phone;
  public Boolean resident;
  public String iin;
  public Number investorId;
  public String idNumber;

  @JsonFormat()
  public Date idValidDate;
  @JsonFormat(pattern = "dd.mm.yyyy")
  public Date dob;

}
