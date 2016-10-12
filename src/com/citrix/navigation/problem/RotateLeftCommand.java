package com.citrix.navigation.problem;

/**
 * Left Rotate Option.
 * @author AkshayB1
 *
 */
public class RotateLeftCommand implements Command {

	@Override
	public void execute(AutomaticRover rover) {
		rover.turnLeft();

	}

	
	@Override
	public String toString() {
		return "RotateLeft";
	}
}
