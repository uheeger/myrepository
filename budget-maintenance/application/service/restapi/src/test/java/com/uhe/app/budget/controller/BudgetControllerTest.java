package com.uhe.app.budget.controller;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.Matchers.hasSize;

import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.uhe.app.budget.model.Payment;
import com.uhe.app.budget.model.response.MonthlyModel;
import com.uhe.app.budget.obj.PaymentType;
import com.uhe.app.budget.service.BudgetService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(
	controllers = BudgetController.class
	)
public class BudgetControllerTest {
	
	@MockBean
	private BudgetService budgetService;
	
	@Autowired
	private MockMvc mockMvc;
	
	static LocalDate now = LocalDate.now();
	
	static int year = now.getYear();
	
	static int month = now.getMonth().getValue();
	
	private static List<Payment> paymentsIn() {
		List<Payment> paymentsIn = new ArrayList<>();
		Payment payment1 = new Payment();
		payment1.setBetrag(BigDecimal.valueOf(15.26));
		payment1.setTyp(PaymentType.EINZAHLUNG);
		Payment payment2 = new Payment();
		payment2.setBetrag(BigDecimal.valueOf(15.26));
		payment2.setTyp(PaymentType.EINZAHLUNG);
		paymentsIn.add(payment1);
		paymentsIn.add(payment2);
		return paymentsIn;
	}
	
	private static Map<String, BigDecimal> paymentsOutSortedByCategory() {
		Map<String, BigDecimal> paymentsOutSortedByCategory = new HashMap<>();
		 paymentsOutSortedByCategory.put("Kino", new BigDecimal("10"));
		 paymentsOutSortedByCategory.put("Restaurant", new BigDecimal("31"));	 
		return paymentsOutSortedByCategory;
	}
	
	private static MonthlyModel monthlyModelTest() {
		return new MonthlyModel(paymentsIn(), 
								paymentsOutSortedByCategory(), 
								year, 
								month, 
								new BigDecimal("14.36"));
	}
	
	@Before
	public void initMocks() {
		when(budgetService.createMonthlyModel(year, month)).thenReturn(monthlyModelTest());
	}
	
	@Test
	public void testGet() throws Exception {
		mockMvc
		.perform(get("/stat?year=" + year + "&month=" + month )
		.accept(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.name", endsWith(Integer.toString(year))))
		.andExpect(jsonPath("$.auszahlungen", hasSize(2)));
	}
}
