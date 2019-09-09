package com.uhe.app.budget.model.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

public class PaymentOutDTO {
	
	@NotNull
	private BigDecimal betrag;
	
	private String kategorie;
	
	public String memo;
	
	public BigDecimal getBetrag() {
		return betrag;
	}

	public void setBetrag(BigDecimal betrag) {
		this.betrag = betrag;
	}

}
