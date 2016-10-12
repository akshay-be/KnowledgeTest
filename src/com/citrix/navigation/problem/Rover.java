package com.citrix.navigation.problem;

/**
 * Rover interface provides the basic capability of what rover can do.
 * 
 * @author AkshayB1
 * 
 */
public interface Rover extends Runnable {

	public void move();

	public void turnLeft();

	public void turnRight();
	
	public void roverRun();
	
	public Coordinates currentLocation();
	
	public String currentPosition();
}
