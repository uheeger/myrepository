package com.uhe.app.budget.controller;


import com.uhe.app.budget.model.Payment;
import com.uhe.app.budget.model.response.MonthlyModel;
import com.uhe.app.budget.service.BudgetService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.math.BigDecimal;
import java.util.Collections;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

@RequestMapping("/")
@Api(value = "/", description = "Test Swagger", produces = "application/json")
public class BudgetController {

	@Autowired
	private BudgetService budgetService;

	@ApiOperation(value = "Einzahlung/Auszahlung", produces = "application/json", response = Payment.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Ungültige Anfrage"),
			@ApiResponse(code = 403, message = "Unerlaubter Zugriff"),
			@ApiResponse(code = 500, message = "Ein allgemeiner Serverfehler ist aufgetreten") })
	@PostMapping("/add")
	public @ResponseBody ResponseEntity<Payment> addPayment(@Valid @RequestBody Payment payment) {
		Payment retVal = budgetService.addPayment(payment).orElseThrow(BudgetException::new);
		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}

	@ApiOperation(value = "Statusabfrage", produces = "application/json", response = MonthlyModel.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Ungültige Anfrage"),
			@ApiResponse(code = 403, message = "Unerlaubter Zugriff"),
			@ApiResponse(code = 500, message = "Ein allgemeiner Serverfehler ist aufgetreten") })
	@GetMapping("/stat")
	public @ResponseBody ResponseEntity<MonthlyModel> askForStat(@RequestParam int year, @RequestParam int month) {
		return new ResponseEntity<>(budgetService.createMonthlyModel(year, month), HttpStatus.OK);
	}

	@ApiOperation(value = "Monatsliste löschen", produces = "application/json", response = MonthlyModel.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Ungültige Anfrage"),
			@ApiResponse(code = 403, message = "Unerlaubter Zugriff"),
			@ApiResponse(code = 500, message = "Ein allgemeiner Serverfehler ist aufgetreten") })
	@DeleteMapping("/delete/{year}/{month}")
	public @ResponseBody ResponseEntity<MonthlyModel> delete(@ApiParam(value = "year", required = true) @PathVariable("year") String year,
			@ApiParam(value = "month", required = true) @PathVariable("month") String month) {
		int y = StringUtils.isNumeric(year) ? Integer.parseInt(year) : 0;
		int m = StringUtils.isNumeric(month) ? Integer.parseInt(month) : 0;
		return new ResponseEntity<>(new MonthlyModel(Collections.<Payment>emptyList(), 
				Collections.<String, BigDecimal>emptyMap(), y,
				m, BigDecimal.ZERO), HttpStatus.OK);
	}

}
