package com.citrix.navigation.problem;

/**
 * Right rotate option.
 * @author AkshayB1
 *
 */
public class RotateRightCommand implements Command {

	@Override
	public void execute(AutomaticRover rover) {
		rover.turnRight();

	}

	@Override
	public String toString() {
		return "RotateRight";
	}
	
	

}
