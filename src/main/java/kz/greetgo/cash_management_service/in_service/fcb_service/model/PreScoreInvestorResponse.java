package kz.greetgo.cash_management_service.in_service.fcb_service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PreScoreInvestorResponse {

  public Integer investorId;
  public Boolean success;
  public String errorDescription;
  public String scoreResult;

  public static PreScoreInvestorResponse of(boolean success, int investorId, String errorDescription,
                                            String scoreResult) {
    PreScoreInvestorResponse ret = new PreScoreInvestorResponse();
    ret.success = success;
    ret.investorId = investorId;
    ret.errorDescription = errorDescription;
    ret.scoreResult = scoreResult;
    return ret;
  }

}
