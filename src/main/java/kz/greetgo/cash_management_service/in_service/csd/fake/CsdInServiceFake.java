package kz.greetgo.cash_management_service.in_service.csd.fake;

import kz.greetgo.cash_management_service.in_service.csd.CsdInService;
import kz.greetgo.cash_management_service.in_service.csd.model.CsdInvestor;
import kz.greetgo.cash_management_service.in_service.csd.model.InvestorToSave;

public class CsdInServiceFake implements CsdInService {

  @Override
  public CsdInvestor saveInvestor(InvestorToSave investorToSave, String brokerId, String sessionId,
                                  String token) {
    return new CsdInvestor();
  }

}
