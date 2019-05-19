package com.uhe.app.budget.controller;

import com.uhe.app.budget.model.MonthlyModel;
import com.uhe.app.budget.model.Payment;
import com.uhe.app.budget.service.BudgetService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BudgetController {
	
	@Autowired
	private BudgetService budgetService;
	
	@PostMapping("/add") 
	public @ResponseBody Payment addPayment(@Valid @RequestBody Payment payment) {	
		 return budgetService.addPayment(payment).orElseThrow(BudgetException::new);
	}
	
	@GetMapping("/stat")
	public @ResponseBody MonthlyModel askForStat(@RequestParam int year, 
												 @RequestParam int month) {
		return budgetService.createMonthlyModel(year, month);
	}

}
