package com.uhe.app.budget.service;

import static java.util.stream.Collectors.toList;

import com.uhe.app.budget.model.Payment;
import com.uhe.app.budget.model.response.MonthlyModel;
import com.uhe.app.budget.obj.PaymentType;

import java.math.BigDecimal;
import java.time.Month;
import java.time.Year;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class BudgetService {

	private List<Payment> payments = new ArrayList<>();

	public MonthlyModel createMonthlyModel(int year, int month) {

		List<Payment> paymentsIn = payments.stream()
				.filter(p -> p.getDatum().query(t -> Year.of(t.get(ChronoField.YEAR))
						.equals(Year.of(year))))
				.filter(p -> p.getDatum().query(t -> Month.of(t.get(ChronoField.MONTH_OF_YEAR))
						.equals(Month.of(month))))
				.filter(p -> p.getTyp().equals(PaymentType.EINZAHLUNG)).collect(toList());

		Map<String, BigDecimal> paymentsOutSortedByCategory = payments.stream()
				.filter(p -> p.getDatum().query(t -> Year.of(t.get(ChronoField.YEAR))
						.equals(Year.of(year))))
				.filter(p -> p.getDatum().query(t -> Month.of(t.get(ChronoField.MONTH_OF_YEAR))
						.equals(Month.of(month))))
				.filter(p -> p.getTyp().equals(PaymentType.AUSZAHLUNG))
				.collect(Collectors.groupingBy(Payment::getKategorie, 
						Collectors.mapping(Payment::getBetrag,
						Collectors.reducing(BigDecimal.ZERO, (sum, elem) -> sum.add(elem)))
						)
				);

		BigDecimal bankBalance = getBankBalance();

		return new MonthlyModel(paymentsIn, 
				paymentsOutSortedByCategory, year, month, bankBalance);
	}

	public BigDecimal getBankBalance() {
		
		BigDecimal sumPaymentsIn = payments.stream()
				.filter(p -> p.getTyp().equals(PaymentType.EINZAHLUNG))
				.map(Payment::getBetrag).filter(Objects::nonNull)
				.reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
		BigDecimal sumPaymentsOut = payments.stream()
				.filter(p -> p.getTyp().equals(PaymentType.AUSZAHLUNG))
				.map(Payment::getBetrag).filter(Objects::nonNull)
				.reduce(BigDecimal::add).orElse(BigDecimal.ZERO);

		return sumPaymentsIn.subtract(sumPaymentsOut);
	}

	public Optional<Payment> addPayment(Payment payment) {
		BigDecimal bankBalance = getBankBalance();
		PaymentType paymentType = payment.getTyp();
		if (paymentType.equals(PaymentType.AUSZAHLUNG) 
				&& bankBalance.subtract(payment.getBetrag())
				.compareTo(BigDecimal.ZERO) < 0) {
			return Optional.empty();
		}
		payments.add(payment);
		return Optional.of(payment);
	}

}
