package com.sanitas.calculator.application.usecase;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.sanitas.calculator.domain.model.BasicArithmeticOperationDTO;
import com.sanitas.calculator.domain.usecase.CalculateBasicArithmeticOperationUseCase;

/**
 * The Class CalculateBasicArithmeticOperationUseCaseImpl.
 */
@Validated
@Service
public class CalculateBasicArithmeticOperationUseCaseImpl implements CalculateBasicArithmeticOperationUseCase {

	@Override
	public Integer calculate(@Valid final BasicArithmeticOperationDTO operation) {
		return 5;
	}

}
