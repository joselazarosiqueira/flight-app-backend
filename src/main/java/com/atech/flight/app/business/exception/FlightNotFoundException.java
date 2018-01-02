package com.atech.flight.app.business.exception;

/**
 * Thrown if a Flight does not exist.
 *
 * @author José Júnior <joselazarosiqueira@gmail.com>
 */

public class FlightNotFoundException extends Exception{

	/**
	 *
	 */
	private static final long serialVersionUID = 2810528586482993824L;

	public FlightNotFoundException(String message) {
		super(message);
	}

}
