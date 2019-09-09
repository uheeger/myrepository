package com.uhe.app.budget.controller;

import com.uhe.app.budget.model.Payment;
import com.uhe.app.budget.model.response.MonthlyModel;
import com.uhe.app.budget.service.BudgetService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

@RequestMapping("/")
@Api(value="/",description="Test Swagger",produces ="application/json")
public class BudgetController {
	
	@Autowired
	private BudgetService budgetService;
	
	@ApiOperation(value = "Einzahlung/Auszahlung", produces = "application/json",
            response = Payment.class)
	@ApiParam(value = "value=\"${property1.description}", hidden=true, required=false)
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "OK"),
            @ApiResponse(code = 400, message = "Ungültige Anfrage"),
            @ApiResponse(code = 403, message = "Unerlaubter Zugriff"),
            @ApiResponse(code = 500, message = "Ein allgemeiner Serverfehler ist aufgetreten")})  
	@PostMapping("/add") 
	public @ResponseBody Payment addPayment(@Valid @RequestBody Payment payment) {	
		 return budgetService.addPayment(payment).orElseThrow(BudgetException::new);
	}
	
	@ApiOperation(value = "Statusabfrage", produces = "application/json",
            response = MonthlyModel.class)
	  @ApiResponses(value = {
	            @ApiResponse(code = 200,
	                    message = "OK"),
	            @ApiResponse(code = 400, message = "Ungültige Anfrage"),
	            @ApiResponse(code = 403, message = "Unerlaubter Zugriff"),
	            @ApiResponse(code = 500, message = "Ein allgemeiner Serverfehler ist aufgetreten")})  
	@GetMapping("/stat")
	public @ResponseBody MonthlyModel askForStat(@RequestParam int year, 
												 @RequestParam int month) {
		return budgetService.createMonthlyModel(year, month);
	}

}
