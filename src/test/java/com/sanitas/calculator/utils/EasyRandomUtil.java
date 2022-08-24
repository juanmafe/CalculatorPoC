package com.sanitas.calculator.utils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.apache.commons.lang3.RandomUtils;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;

import io.github.xshadov.easyrandom.vavr.VavrRandomizerRegistry;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * The Class EasyRandomUtil.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EasyRandomUtil {

	/**
	 * Basic parameters.
	 *
	 * @param vavrRandomizerRegistry the vavr randomizer registry
	 * @return the easy random parameters
	 */
	public final static EasyRandomParameters BASIC_PARAMETERS(final VavrRandomizerRegistry vavrRandomizerRegistry) {

		final Charset charset = StandardCharsets.UTF_8;

		return new EasyRandomParameters().seed(12345L).objectPoolSize(100).randomizationDepth(3).charset(charset)
				.collectionSizeRange(1, 10).scanClasspathForConcreteTypes(true).overrideDefaultInitialization(false)
				.ignoreRandomizationErrors(true).randomize(Integer.class, () -> RandomUtils.nextInt(1, 999))
				.randomizerRegistry(vavrRandomizerRegistry);
	}

	/**
	 * Basic random.
	 *
	 * @return the easy random
	 */
	public final static EasyRandom BASIC_RANDOM() {
		final VavrRandomizerRegistry vavrRandomizerRegistry = new VavrRandomizerRegistry();
		final EasyRandom random = new EasyRandom(BASIC_PARAMETERS(vavrRandomizerRegistry));
		vavrRandomizerRegistry.setEasyRandom(random);
		return random;
	}

}
