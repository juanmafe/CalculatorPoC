package com.sanitas.calculator.application.strategy;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import com.sanitas.calculator.domain.model.BasicArithmeticOperationEnum;

/**
 * The Class SubtractionOperation.
 */
@Validated
@Component
public class SubtractionOperation implements BasicArithmeticOperationStrategy {

	@Override
	public BasicArithmeticOperationEnum getType() {
		return BasicArithmeticOperationEnum.SUBTRACTION;
	}

	@Override
	public Integer getResult(@NotNull final Integer firstValue, @NotNull final Integer secondValue) {
		return firstValue - secondValue;
	}

}
