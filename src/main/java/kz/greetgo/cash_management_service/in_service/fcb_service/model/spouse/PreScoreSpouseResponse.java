package kz.greetgo.cash_management_service.in_service.fcb_service.model.spouse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PreScoreSpouseResponse {

  public Boolean success;
  public String errorDescription;
  public String scoreResult;

  public static PreScoreSpouseResponse of(boolean success, String errorDescription,
                                          String scoreResult) {
    PreScoreSpouseResponse ret = new PreScoreSpouseResponse();
    ret.success = success;
    ret.errorDescription = errorDescription;
    ret.scoreResult = scoreResult;
    return ret;
  }

}
