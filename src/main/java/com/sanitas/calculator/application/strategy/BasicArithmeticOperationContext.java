package com.sanitas.calculator.application.strategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import com.sanitas.calculator.domain.model.BasicArithmeticOperationDTO;
import com.sanitas.calculator.domain.model.BasicArithmeticOperationEnum;

/**
 * The Class BasicArithmeticOperationContext.
 */
@Validated
@Component
public class BasicArithmeticOperationContext implements InitializingBean {

	/** The basic arithmetic operation strategies. */
	@Autowired
	private List<BasicArithmeticOperationStrategy> basicArithmeticStrategies;

	/** The map. */
	private Map<BasicArithmeticOperationEnum, BasicArithmeticOperationStrategy> map;

	@Override
	public void afterPropertiesSet() throws Exception {
		this.map = new HashMap<>();
		basicArithmeticStrategies.forEach(
				basicArithmeticStrategies -> map.put(basicArithmeticStrategies.getType(), basicArithmeticStrategies));
	}

	/**
	 * Gets the result.
	 *
	 * @param operation the operation
	 * @return the result
	 */
	public Integer getResult(@Valid final BasicArithmeticOperationDTO operation) {
		return this.map.get(operation.getBasicArithmeticOperator()).getResult(operation.getFirstNumber(),
				operation.getSecondNumber());
	}

}
