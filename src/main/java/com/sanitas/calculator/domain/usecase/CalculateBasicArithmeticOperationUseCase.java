package com.sanitas.calculator.domain.usecase;

import com.sanitas.calculator.domain.model.BasicArithmeticOperationDTO;

/**
 * The Interface CalculateBasicArithmeticOperationUseCase.
 */
public interface CalculateBasicArithmeticOperationUseCase {

	/**
	 * Calculate.
	 *
	 * @param operation the operation
	 * @return the integer
	 */
	Integer calculate(BasicArithmeticOperationDTO operation);

}
