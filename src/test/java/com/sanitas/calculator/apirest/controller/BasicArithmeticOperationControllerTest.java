package com.sanitas.calculator.apirest.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@WebMvcTest(BasicArithmeticOperationController.class)
class BasicArithmeticOperationControllerTest {

	/** The mock mvc. */
	@Autowired
	MockMvc mockMvc;

	/** The first number. */
	static String FIRST_NUMBER = "firstNumber";

	/** The second number. */
	static String SECOND_NUMBER = "secondNumber";

	/** The basic arithmetic operator. */
	static String BASIC_ARITHMETIC_OPERATOR = "basicArithmeticOperator";

	/**
	 * Test basic arithmetic operation V 1 addition success.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testBasicArithmeticOperationV1_addition_success() throws Exception {
		final ResultActions response = this.mockMvc
				.perform(get("/api/v1/arithmetic/basic").header(FIRST_NUMBER, 2).header(SECOND_NUMBER, 2)
						.header(BASIC_ARITHMETIC_OPERATOR, "ADDITION").contentType(MediaType.APPLICATION_JSON));
		response.andDo(print()).andExpect(status().isOk());
	}

	/**
	 * Test basic arithmetic operation V 1 subtraction success.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testBasicArithmeticOperationV1_subtraction_success() throws Exception {
		final ResultActions response = this.mockMvc
				.perform(get("/api/v1/arithmetic/basic").header(FIRST_NUMBER, 4).header(SECOND_NUMBER, 2)
						.header(BASIC_ARITHMETIC_OPERATOR, "SUBTRACTION").contentType(MediaType.APPLICATION_JSON));
		response.andDo(print()).andExpect(status().isOk());
	}

	/**
	 * Test basic arithmetic operation V 1 first number fail.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testBasicArithmeticOperationV1_firstNumber_fail() throws Exception {
		final ResultActions response = this.mockMvc.perform(get("/api/v1/arithmetic/basic").header(SECOND_NUMBER, 5)
				.header(BASIC_ARITHMETIC_OPERATOR, "ADDITION").contentType(MediaType.APPLICATION_JSON));
		response.andDo(print()).andExpect(status().is4xxClientError());
	}

	/**
	 * Test basic arithmetic operation V 1 second number fail.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testBasicArithmeticOperationV1_secondNumber_fail() throws Exception {
		final ResultActions response = this.mockMvc.perform(get("/api/v1/arithmetic/basic").header(FIRST_NUMBER, 6)
				.header(BASIC_ARITHMETIC_OPERATOR, "SUBTRACTION").contentType(MediaType.APPLICATION_JSON));
		response.andDo(print()).andExpect(status().is4xxClientError());
	}

	/**
	 * Test basic arithmetic operation V 1 basic arithmetic operator fail.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testBasicArithmeticOperationV1_basicArithmeticOperator_fail() throws Exception {
		final ResultActions response = this.mockMvc.perform(get("/api/v1/arithmetic/basic").header(FIRST_NUMBER, 4)
				.header(SECOND_NUMBER, 1).contentType(MediaType.APPLICATION_JSON));
		response.andDo(print()).andExpect(status().is4xxClientError());
	}
}
