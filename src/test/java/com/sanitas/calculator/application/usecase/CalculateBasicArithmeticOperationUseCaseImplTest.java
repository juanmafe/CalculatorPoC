package com.sanitas.calculator.application.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.sanitas.calculator.application.strategy.AdditionOperation;
import com.sanitas.calculator.application.strategy.BasicArithmeticOperationContext;
import com.sanitas.calculator.application.strategy.SubtractionOperation;
import com.sanitas.calculator.domain.model.BasicArithmeticOperationDTO;
import com.sanitas.calculator.domain.model.BasicArithmeticOperationEnum;
import com.sanitas.calculator.domain.usecase.CalculateBasicArithmeticOperationUseCase;
import com.sanitas.calculator.utils.EasyRandomUtil;

/**
 * The Class CalculateBasicArithmeticOperationUseCaseImplTest.
 */
@ExtendWith({ SpringExtension.class, MockitoExtension.class })
@ContextConfiguration(classes = { CalculateBasicArithmeticOperationUseCaseImpl.class,
		BasicArithmeticOperationContext.class, AdditionOperation.class, SubtractionOperation.class })
class CalculateBasicArithmeticOperationUseCaseImplTest {

	/** The calculate basic arithmetic operation use case. */
	@Autowired
	CalculateBasicArithmeticOperationUseCase calculateBasicArithmeticOperationUseCase;

	/**
	 * Test calculate addition success.
	 */
	@Test
	void testCalculate_addition_success() {

		final EasyRandom generator = EasyRandomUtil.BASIC_RANDOM();
		final BasicArithmeticOperationDTO operation = generator.nextObject(BasicArithmeticOperationDTO.class);
		operation.setBasicArithmeticOperator(BasicArithmeticOperationEnum.ADDITION);

		final Integer response = this.calculateBasicArithmeticOperationUseCase.calculate(operation);
		assertEquals(operation.getFirstNumber() + operation.getSecondNumber(), response);
	}

	/**
	 * Test calculate subtraction success.
	 */
	@Test
	void testCalculate_subtraction_success() {

		final EasyRandom generator = EasyRandomUtil.BASIC_RANDOM();
		final BasicArithmeticOperationDTO operation = generator.nextObject(BasicArithmeticOperationDTO.class);
		operation.setBasicArithmeticOperator(BasicArithmeticOperationEnum.SUBTRACTION);

		final Integer response = this.calculateBasicArithmeticOperationUseCase.calculate(operation);
		assertEquals(operation.getFirstNumber() - operation.getSecondNumber(), response);
	}

	/**
	 * Test calculate first number fail.
	 */
	@Test
	void testCalculate_firstNumber_fail() {

		final EasyRandom generator = EasyRandomUtil.BASIC_RANDOM();
		final BasicArithmeticOperationDTO operation = generator.nextObject(BasicArithmeticOperationDTO.class);
		operation.setFirstNumber(null);

		final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			this.calculateBasicArithmeticOperationUseCase.calculate(operation);
		});

		assertTrue(exception.getMessage().contains("Invalid parameter"));
	}

	/**
	 * Test calculate second number fail.
	 */
	@Test
	void testCalculate_secondNumber_fail() {

		final EasyRandom generator = EasyRandomUtil.BASIC_RANDOM();
		final BasicArithmeticOperationDTO operation = generator.nextObject(BasicArithmeticOperationDTO.class);
		operation.setSecondNumber(null);

		final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			this.calculateBasicArithmeticOperationUseCase.calculate(operation);
		});

		assertTrue(exception.getMessage().contains("Invalid parameter"));
	}

	/**
	 * Test calculate basic arithmetic operator fail.
	 */
	@Test
	void testCalculate_basicArithmeticOperator_fail() {

		final EasyRandom generator = EasyRandomUtil.BASIC_RANDOM();
		final BasicArithmeticOperationDTO operation = generator.nextObject(BasicArithmeticOperationDTO.class);
		operation.setBasicArithmeticOperator(null);

		final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			this.calculateBasicArithmeticOperationUseCase.calculate(operation);
		});

		assertTrue(exception.getMessage().contains("Invalid parameter"));
	}

}
