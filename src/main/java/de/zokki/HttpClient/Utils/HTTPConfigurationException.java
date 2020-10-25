package de.zokki.HttpClient.Utils;

public class HTTPConfigurationException extends RuntimeException{

	private static final long serialVersionUID = 3592384573164651586L;

	
	public HTTPConfigurationException(String message) {
		super(message);
	}
	
	public HTTPConfigurationException(String message, Throwable cause) {
		super(message, cause);
	}

	public HTTPConfigurationException(Throwable cause) {
		super(cause);
	}
}
