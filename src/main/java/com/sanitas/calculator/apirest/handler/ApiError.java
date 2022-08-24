package com.sanitas.calculator.apirest.handler;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

/**
 * The Class ApiError.
 */
@Getter
@Builder
@AllArgsConstructor
public class ApiError {

	/** The title. */
	private final String title;

	/** The status. */
	private final HttpStatus status;

	/** The message. */
	private final String message;

	/** The errors. */
	@Singular
	private final List<Object> errors;

	/**
	 * Instantiates a new api error.
	 *
	 * @param title the title
	 * @param status the status
	 * @param message the message
	 * @param error the error
	 */
	public ApiError(final String title, final HttpStatus status, final String message, final Object error) {
		super();
		this.title = title;
		this.status = status;
		this.message = message;
		this.errors = Arrays.asList(error);
	}

}
