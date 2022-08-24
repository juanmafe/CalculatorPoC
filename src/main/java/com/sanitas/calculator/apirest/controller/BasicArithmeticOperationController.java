package com.sanitas.calculator.apirest.controller;

import javax.validation.Valid;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import com.sanitas.api.BasicArithmeticOperationV1Api;
import com.sanitas.model.BasicArithmeticOperationRequestDTO;

/**
 * The Class BasicArithmeticOperationController.
 */
@Validated
@RestController
public class BasicArithmeticOperationController implements BasicArithmeticOperationV1Api {

	@Override
	public ResponseEntity<Integer> basicArithmeticOperationV1(
			@Valid final BasicArithmeticOperationRequestDTO basicArithmeticOperationRequestDTO) {
		
		if (ObjectUtils.anyNull(basicArithmeticOperationRequestDTO.getFirstNumber(),
				basicArithmeticOperationRequestDTO.getSecondNumber(),
				basicArithmeticOperationRequestDTO.getBasicArithmeticOperator())) {
			throw new IllegalArgumentException();
		}
		return new ResponseEntity<>(5, HttpStatus.OK);
	}

}
