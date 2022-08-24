package com.sanitas.calculator.apirest.mapper;

import org.mapstruct.Mapper;

import com.sanitas.calculator.domain.model.BasicArithmeticOperationEnum;
import com.sanitas.model.BasicArithmeticOperationRequestDTO.BasicArithmeticOperatorEnum;

/**
 * The Interface BasicArithmeticOperationMapper.
 */
@Mapper(componentModel = "spring")
public interface BasicArithmeticOperationMapper {

	/**
	 * To basic arithmetic operation enum.
	 *
	 * @param basicArithmeticOperatorEnum the basic arithmetic operator enum
	 * @return the basic arithmetic operation enum
	 */
	BasicArithmeticOperationEnum toBasicArithmeticOperationEnum(
			BasicArithmeticOperatorEnum basicArithmeticOperatorEnum);

}
