package com.uhe.app.budget.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class BudgetException extends RuntimeException {

	private static final long serialVersionUID = -7309319688886558676L;

}
