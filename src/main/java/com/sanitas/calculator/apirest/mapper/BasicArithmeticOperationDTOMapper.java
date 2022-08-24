package com.sanitas.calculator.apirest.mapper;

import org.mapstruct.Mapper;

import com.sanitas.calculator.domain.model.BasicArithmeticOperationDTO;
import com.sanitas.model.BasicArithmeticOperationRequestDTO;

/**
 * The Interface BasicArithmeticOperationDTOMapper.
 */
@Mapper(componentModel = "spring")
public interface BasicArithmeticOperationDTOMapper {

	/**
	 * To basic arithmetic operation DTO.
	 *
	 * @param request the request
	 * @return the basic arithmetic operation DTO
	 */
	BasicArithmeticOperationDTO toBasicArithmeticOperationDTO(BasicArithmeticOperationRequestDTO request);

}
