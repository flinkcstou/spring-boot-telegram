package kz.greetgo.cash_management_service.in_service.csd;

import kz.greetgo.cash_management_service.in_service.csd.model.CsdInvestor;
import kz.greetgo.cash_management_service.in_service.csd.model.InvestorToSave;

public interface CsdInService {

  CsdInvestor saveInvestor(InvestorToSave investorToSave, String brokerId, String sessionId, String token);

}
