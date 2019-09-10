package com.uhe.app.budget.model;

import com.uhe.app.budget.obj.PaymentType;

import java.math.BigDecimal;
import java.time.LocalDate;


import org.springframework.lang.Nullable;

public class Payment {


	private BigDecimal betrag;


	private PaymentType typ;

	private LocalDate datum = LocalDate.now();
	
	@Nullable
	private String kategorie;
	
	@Nullable
	public String memo;
	
	public BigDecimal getBetrag() {
		return betrag;
	}

	public void setBetrag(BigDecimal betrag) {
		this.betrag = betrag;
	}

	public PaymentType getTyp() {
		return typ;
	}

	public void setTyp(PaymentType typ) {
		this.typ = typ;
	}

	public LocalDate getDatum() {
		return datum;
	}

	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}

	public String getKategorie() {
		return kategorie;
	}

	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
