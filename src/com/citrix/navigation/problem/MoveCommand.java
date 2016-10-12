package com.citrix.navigation.problem;

/**
 * Move command.
 * Actually it will move one step forward.
 * @author AkshayB1
 *
 */
public class MoveCommand implements Command{

	@Override
    public void execute(AutomaticRover rover) {
        rover.move();
    }
	
	
	@Override
	public String toString() {
		return "Move";
	}
}
