package com.sanitas.calculator.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unused")
public class BasicArithmeticOperationDTO {

	private BasicArithmeticOperationEnum basicArithmeticOperator;

	private Integer firstNumber;

	private Integer secondNumber;

}
