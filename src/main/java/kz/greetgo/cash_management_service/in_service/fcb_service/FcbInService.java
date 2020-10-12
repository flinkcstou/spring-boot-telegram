package kz.greetgo.cash_management_service.in_service.fcb_service;

import kz.greetgo.cash_management_service.in_service.fcb_service.model.PreScoreInvestorRequest;
import kz.greetgo.cash_management_service.in_service.fcb_service.model.PreScoreInvestorResponse;
import kz.greetgo.cash_management_service.in_service.fcb_service.model.spouse.PreScoreSpouseRequest;
import kz.greetgo.cash_management_service.in_service.fcb_service.model.spouse.PreScoreSpouseResponse;

public interface FcbInService {

  PreScoreInvestorResponse getInvestorPreScore(PreScoreInvestorRequest preScoreInvestorRequest,
                                               String sessionId, String token);

  PreScoreSpouseResponse getInvestorSpousePreScore(
    PreScoreSpouseRequest preScoreSpouseRequest, String sessionId, String token);

}
