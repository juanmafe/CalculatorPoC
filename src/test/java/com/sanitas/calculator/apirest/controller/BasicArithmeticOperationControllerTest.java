package com.sanitas.calculator.apirest.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sanitas.calculator.apirest.handler.RestErrorHandler;
import com.sanitas.calculator.apirest.mapper.BasicArithmeticOperationDTOMapperImpl;
import com.sanitas.calculator.domain.model.BasicArithmeticOperationDTO;
import com.sanitas.calculator.domain.usecase.CalculateBasicArithmeticOperationUseCase;
import com.sanitas.calculator.utils.EasyRandomUtil;
import com.sanitas.model.BasicArithmeticOperationRequestDTO;

/**
 * The Class BasicArithmeticOperationControllerTest.
 */
@WebMvcTest(BasicArithmeticOperationController.class)
@ContextConfiguration(classes = { BasicArithmeticOperationController.class, RestErrorHandler.class,
		BasicArithmeticOperationDTOMapperImpl.class })
class BasicArithmeticOperationControllerTest {

	/** The mock mvc. */
	@Autowired
	MockMvc mockMvc;

	/** The object mapper. */
	@Autowired
	ObjectMapper objectMapper;

	/** The use case. */
	@MockBean
	CalculateBasicArithmeticOperationUseCase useCase;

	/**
	 * Test basic arithmetic operation V 1 success.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testBasicArithmeticOperationV1_success() throws Exception {

		final EasyRandom generator = EasyRandomUtil.BASIC_RANDOM();
		final BasicArithmeticOperationRequestDTO request = generator
				.nextObject(BasicArithmeticOperationRequestDTO.class);

		when(this.useCase.calculate(any(BasicArithmeticOperationDTO.class))).thenReturn(7);

		final ResultActions response = this.mockMvc.perform(post("/api/v1/arithmetic/basic")
				.content(this.objectMapper.writeValueAsString(request)).contentType(MediaType.APPLICATION_JSON));

		verify(this.useCase, times(1)).calculate(any(BasicArithmeticOperationDTO.class));
		response.andDo(print()).andExpect(status().isOk());
	}

	/**
	 * Test basic arithmetic operation V 1 fail.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testBasicArithmeticOperationV1_fail() throws Exception {

		when(this.useCase.calculate(any(BasicArithmeticOperationDTO.class))).thenReturn(7);

		final ResultActions response = this.mockMvc.perform(post("/api/v1/arithmetic/basic")
				.content(this.objectMapper.writeValueAsString(null)).contentType(MediaType.APPLICATION_JSON));

		verify(this.useCase, times(0)).calculate(any(BasicArithmeticOperationDTO.class));
		response.andDo(print()).andExpect(status().isBadRequest());
	}

}
