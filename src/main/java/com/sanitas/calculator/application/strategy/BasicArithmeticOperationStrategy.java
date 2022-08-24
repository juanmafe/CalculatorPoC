package com.sanitas.calculator.application.strategy;

import com.sanitas.calculator.domain.model.BasicArithmeticOperationEnum;

/**
 * The Interface BasicArithmeticOperationStrategy.
 */
public interface BasicArithmeticOperationStrategy {

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	BasicArithmeticOperationEnum getType();

	/**
	 * Gets the result.
	 *
	 * @param firstValue  the first value
	 * @param secondValue the second value
	 * @return the result
	 */
	Integer getResult(Integer firstValue, Integer secondValue);

}
