package com.sanitas.calculator.apirest.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import com.sanitas.api.BasicArithmeticOperationV1Api;

/**
 * The Class BasicArithmeticOperationController.
 */
@Validated
@RestController
public class BasicArithmeticOperationController implements BasicArithmeticOperationV1Api {

	@Override
	public ResponseEntity<Integer> basicArithmeticOperationV1(@NotNull final Integer firstNumber, @NotNull final Integer secondNumber,
			@Valid final String basicArithmeticOperator) {
		return new ResponseEntity<>(5, HttpStatus.OK);
	}

}
