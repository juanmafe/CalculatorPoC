package com.sanitas.calculator.apirest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sanitas.model.BasicArithmeticOperationRequestDTO;
import com.sanitas.model.BasicArithmeticOperationRequestDTO.BasicArithmeticOperatorEnum;

@WebMvcTest(BasicArithmeticOperationController.class)
class BasicArithmeticOperationControllerTest {

	/** The mock mvc. */
	@Autowired
	MockMvc mockMvc;

	/** The object mapper. */
	@Autowired
	ObjectMapper objectMapper;

	/**
	 * Test basic arithmetic operation V 1 success.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testBasicArithmeticOperationV1_success() throws Exception {

		BasicArithmeticOperationRequestDTO request = new BasicArithmeticOperationRequestDTO();
		request.setBasicArithmeticOperator(BasicArithmeticOperatorEnum.ADDITION);
		request.setFirstNumber(5);
		request.setSecondNumber(4);

		final ResultActions response = this.mockMvc.perform(post("/api/v1/arithmetic/basic")
				.content(this.objectMapper.writeValueAsString(request))
				.contentType(MediaType.APPLICATION_JSON));
		response.andDo(print()).andExpect(status().isOk());
	}

	/**
	 * Test basic arithmetic operation V 1 first number fail.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testBasicArithmeticOperationV1_firstNumber_fail() throws Exception {

		BasicArithmeticOperationRequestDTO request = new BasicArithmeticOperationRequestDTO();
		request.setBasicArithmeticOperator(BasicArithmeticOperatorEnum.ADDITION);
		request.setSecondNumber(4);

		final ResultActions response = this.mockMvc.perform(post("/api/v1/arithmetic/basic")
				.content(this.objectMapper.writeValueAsString(request))
				.contentType(MediaType.APPLICATION_JSON));
		response.andDo(print()).andExpect(status().is4xxClientError());
	}

	/**
	 * Test basic arithmetic operation V 1 second number fail.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testBasicArithmeticOperationV1_secondNumber_fail() throws Exception {

		BasicArithmeticOperationRequestDTO request = new BasicArithmeticOperationRequestDTO();
		request.setBasicArithmeticOperator(BasicArithmeticOperatorEnum.ADDITION);
		request.setFirstNumber(5);

		final ResultActions response = this.mockMvc.perform(post("/api/v1/arithmetic/basic")
				.content(this.objectMapper.writeValueAsString(request))
				.contentType(MediaType.APPLICATION_JSON));
		response.andDo(print()).andExpect(status().is4xxClientError());
	}

	/**
	 * Test basic arithmetic operation V 1 basic arithmetic operator fail.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testBasicArithmeticOperationV1_basicArithmeticOperator_fail() throws Exception {

		BasicArithmeticOperationRequestDTO request = new BasicArithmeticOperationRequestDTO();
		request.setFirstNumber(5);
		request.setSecondNumber(4);

		final ResultActions response = this.mockMvc.perform(post("/api/v1/arithmetic/basic")
				.content(this.objectMapper.writeValueAsString(request))
				.contentType(MediaType.APPLICATION_JSON));
		response.andDo(print()).andExpect(status().is4xxClientError());
	}
}
