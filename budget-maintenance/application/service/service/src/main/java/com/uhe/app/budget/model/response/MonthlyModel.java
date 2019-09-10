package com.uhe.app.budget.model.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import com.uhe.app.budget.model.Payment;

public class MonthlyModel {

	private int year;
	
	private int month;
	
	private String name;
	
	private BigDecimal kassenbestand;

	private List<Payment> einzahlungen;

	private Map<String, BigDecimal> auszahlungen;

	public MonthlyModel(List<Payment> einzahlungen, 
						Map<String, BigDecimal> auszahlungen, 
						int year,
						int month,
						BigDecimal kassenbestand) {
		this.einzahlungen = einzahlungen;
		this.auszahlungen = auszahlungen;
		this.year = year;
		this.month = month;
		this.kassenbestand = kassenbestand;
	}
	
	public String getName() {
		LocalDate d = LocalDate.of(year, month, 1);
		Locale l = Locale.GERMAN;
		this.name = d.format(DateTimeFormatter.ofPattern("MMM yyyy",l));
		return name;
	}

	public BigDecimal getKassenbestand() {
		return kassenbestand;
	}

	public List<ReturnPaymentIn> getEinzahlungen() {
		return einzahlungen.stream().map(ReturnPaymentIn::new).collect(Collectors.toList());
	}

	public List<ReturnPaymentOut> getAuszahlungen() {
		return this.auszahlungen.entrySet()
				.stream().map(e -> new ReturnPaymentOut(e.getKey(), e.getValue()))
				.collect(Collectors.toList());
	}

	private class ReturnPaymentOut {
		String kategorie;
		BigDecimal summe;

		public ReturnPaymentOut(String kategorie, BigDecimal summe) {
			super();
			this.kategorie = kategorie;
			this.summe = summe;
		}

		public String getKategorie() {
			return kategorie;
		}

		public BigDecimal getSumme() {
			return summe;
		}

	}

	private class ReturnPaymentIn {

		Payment payment;

		public ReturnPaymentIn(Payment payment) {
			super();
			this.payment = payment;
		}
		
		public String getDatum() {
			LocalDate date = this.payment.getDatum();
			return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy", 
							   new Locale("de")));
		}

		public BigDecimal getBetrag() {
			return payment.getBetrag();
		}
		
	}

}
