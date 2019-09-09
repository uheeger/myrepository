package com.uhe.app.budget.model.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

public class PaymentInDTO {
	
	@NotNull
	private BigDecimal betrag;
	
	public BigDecimal getBetrag() {
		return betrag;
	}

	public void setBetrag(BigDecimal betrag) {
		this.betrag = betrag;
	}

}
