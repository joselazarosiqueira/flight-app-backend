package com.atech.flight.app.business.exception;

/**
 * The class to handle exceptions on Flight App.
 *
 * @author  José Júnior <joselazarosiqueira@gmail.com>
 */
public class FlightException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2810528586482993824L;	

	public FlightException(String message) {
		super(message);
	}

	public FlightException(String message, Throwable ex) {
		super(message, ex);
	}

	public FlightException(Throwable ex) {
		super(ex);
	}

}
