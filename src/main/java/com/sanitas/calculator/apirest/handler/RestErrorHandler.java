package com.sanitas.calculator.apirest.handler;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.LocaleResolver;

/**
 * The Class RestErrorHandler.
 */
@RestControllerAdvice("com.sanitas.calculator.apirest.controller")
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestErrorHandler {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(RestErrorHandler.class);

	/** The error source. */
	@Autowired
	private MessageSource errorSource;

	/** The locale resolver. */
	@Autowired
	private LocaleResolver localeResolver;

	/**
	 * Handle exception.
	 *
	 * @param excep the excep
	 * @param request the request
	 * @param response the response
	 * @return the api error
	 */
	@ExceptionHandler(value = { IllegalArgumentException.class })
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ApiError handleException(final IllegalArgumentException excep, final HttpServletRequest request,
			final HttpServletResponse response) {

		final Locale locale = this.localeResolver.resolveLocale(request);

		final String error = this.getErrorMessage(excep, locale);

		LOGGER.error(error);
		return ApiError.builder().title(HttpStatus.BAD_REQUEST.getReasonPhrase()).status(HttpStatus.BAD_REQUEST)
				.message(excep.getLocalizedMessage()).error(excep.getMessage()).build();
	}

	/**
	 * Gets the error message.
	 *
	 * @param excep  the excep
	 * @param locale the locale
	 * @param params the params
	 * @return the error message
	 */
	private String getErrorMessage(final Exception excep, final Locale locale, final Object... params) {
		try {
			return this.errorSource.getMessage(excep.getMessage(), params, locale);
		} catch (final Exception ex) {
			return excep.getMessage();
		}
	}

}
