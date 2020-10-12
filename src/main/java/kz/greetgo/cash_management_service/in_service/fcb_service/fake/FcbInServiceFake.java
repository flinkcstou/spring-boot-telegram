package kz.greetgo.cash_management_service.in_service.fcb_service.fake;

import kz.greetgo.cash_management_service.in_service.fcb_service.FcbInService;
import kz.greetgo.cash_management_service.in_service.fcb_service.model.PreScoreInvestorRequest;
import kz.greetgo.cash_management_service.in_service.fcb_service.model.PreScoreInvestorResponse;
import kz.greetgo.cash_management_service.in_service.fcb_service.model.spouse.PreScoreSpouseRequest;
import kz.greetgo.cash_management_service.in_service.fcb_service.model.spouse.PreScoreSpouseResponse;

public class FcbInServiceFake implements FcbInService {

  @Override
  public PreScoreInvestorResponse getInvestorPreScore(
    PreScoreInvestorRequest preScoreInvestorRequest, String sessionId, String token) {
    return PreScoreInvestorResponse.of(true, 1231, null, null);
  }

  @Override
  public PreScoreSpouseResponse getInvestorSpousePreScore(
    PreScoreSpouseRequest preScoreSpouseRequest, String sessionId, String token) {
    return PreScoreSpouseResponse.of(true, null, null);
  }

}
