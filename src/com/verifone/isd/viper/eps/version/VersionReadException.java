package com.verifone.isd.viper.eps.version;

/**
 * This class represents the exception thrown to the caller if there is any
 * Not able to read version info.
 * @author akshayb1
 *
 */
public class VersionReadException extends Exception {

	private static final long serialVersionUID = -7022877444917962116L;

	public VersionReadException(String msg){
		super(msg);
	}
}
