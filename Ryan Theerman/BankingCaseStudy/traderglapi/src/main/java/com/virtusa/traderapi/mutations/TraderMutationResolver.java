package com.virtusa.traderapi.mutations;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.virtusa.traderapi.models.*;
import com.virtusa.traderapi.services.BankService;
import com.virtusa.traderapi.services.TraderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TraderMutationResolver implements GraphQLMutationResolver{
	@Autowired
	private TraderService traderService;
	@Autowired
	private BankService bankService;

	public Trader createTrader(TraderInput traderInput) {

			return this.traderService.addTrader(traderInput.getBank().getBankId(),
					new Trader(0,new FullName(traderInput.getName().getFirstName(),traderInput.getName().getLastName(),
							traderInput.getName().getMiddleName()),traderInput.getTradingLimit(),
							traderInput.getEmail(),LocalDate.parse(traderInput.getDob()),null));

		}

	public Trader updateTrader(long traderId, String email) {
		return this.traderService.updateTrader(traderId, email);
	}

	public Boolean deleteTrader(Long traderId) {
		return this.traderService.deleteTraderById(traderId);
	}
}
