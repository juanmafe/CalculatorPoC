package com.sanitas.calculator.apirest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import com.sanitas.api.BasicArithmeticOperationV1Api;
import com.sanitas.calculator.apirest.mapper.BasicArithmeticOperationDTOMapper;
import com.sanitas.calculator.domain.usecase.CalculateBasicArithmeticOperationUseCase;
import com.sanitas.model.BasicArithmeticOperationRequestDTO;

/**
 * The Class BasicArithmeticOperationController.
 */
@Validated
@RestController
public class BasicArithmeticOperationController implements BasicArithmeticOperationV1Api {

	/** The calculate basic arithmetic operation use case. */
	@Autowired
	private CalculateBasicArithmeticOperationUseCase calculateBasicArithmeticOperationUseCase;

	/** The basic arithmetic operation DTO mapper. */
	@Autowired
	private BasicArithmeticOperationDTOMapper basicArithmeticOperationDTOMapper;

	@Override
	public ResponseEntity<Integer> basicArithmeticOperationV1(
			@Valid final BasicArithmeticOperationRequestDTO basicArithmeticOperationRequestDTO) {

		final Integer result = calculateBasicArithmeticOperationUseCase.calculate(this.basicArithmeticOperationDTOMapper
				.toBasicArithmeticOperationDTO(basicArithmeticOperationRequestDTO));

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
