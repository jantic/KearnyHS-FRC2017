package org.usfirst.frc.team1572.vision.camera;

public class ImageGrabFailedException extends Exception {
	private static final long serialVersionUID = 1L;

	public ImageGrabFailedException(final String message, final Exception innerException){
		super(message, innerException);
	}
	
	public ImageGrabFailedException(final String message){
		super(message);
	}
}
