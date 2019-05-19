package com.uhe.app.budget.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.junit4.SpringRunner;

import com.uhe.app.budget.model.MonthlyModel;
import com.uhe.app.budget.model.Payment;
import com.uhe.app.budget.obj.PaymentType;
import com.uhe.app.budget.service.BudgetService;

@RunWith(SpringRunner.class)
public class BudgetServiceTest {

	private BudgetService budgetService;
	
	private static List<Payment> payments() {
		List<Payment> payments = new ArrayList<>();
		
		Payment payment1 = new Payment();
		payment1.setBetrag(BigDecimal.valueOf(51));
		payment1.setTyp(PaymentType.EINZAHLUNG);
		Payment payment2 = new Payment();
		payment2.setBetrag(BigDecimal.valueOf(49));
		payment2.setTyp(PaymentType.EINZAHLUNG);
		
		Payment payment3 = new Payment();
		payment3.setBetrag(BigDecimal.valueOf(15.26));
		payment3.setTyp(PaymentType.AUSZAHLUNG);
		payment3.setKategorie("Restaurant");
		Payment payment4 = new Payment();
		payment4.setBetrag(BigDecimal.valueOf(70.38));
		payment4.setTyp(PaymentType.AUSZAHLUNG);
		payment4.setKategorie("Restaurant");
		
		payments.add(payment1);
		payments.add(payment2);
		payments.add(payment3);
		payments.add(payment4);
		
		return payments;
	}

	@Before
	public void init() {
		budgetService = new BudgetService();
		payments().stream().forEach(p -> budgetService.addPayment(p)); 
	}

	@Test
	public void test() throws Exception {
		  LocalDate now = LocalDate.now();
		  int year = now.getYear();
		  int month = now.getMonth().getValue();
		  MonthlyModel monthlyModel = budgetService.createMonthlyModel(year, month);  
			assertThat(
					monthlyModel.getEinzahlungen().size(), 
					is(2));
			assertThat(
					monthlyModel.getAuszahlungen().size(), 
					is(1));
			
		  int lastYear = year - 1;
		  MonthlyModel monthlyModelLastYear = budgetService
				  								.createMonthlyModel(lastYear, month);
			assertThat(
					monthlyModelLastYear.getAuszahlungen().size(), 
					is(0));
			assertEquals(monthlyModel.getKassenbestand(), new BigDecimal("14.36"));
	}
	
}
