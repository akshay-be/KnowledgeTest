package com.citrix.navigation.problem;

public class TestAutomaticRover {

	public static void main(String[] args) {
		
		RoverManager rovManager = RoverManager.getInstance();
		Plateau plateau = new Plateau(5,5);
		rovManager.setPlateau(plateau);
        Rover rover1 = new AutomaticRover("Rov1",Direction.East, new Coordinates(2,2),"MMMMRMMRMRRM");
        Rover rover2 = new AutomaticRover("Rov2",Direction.East, new Coordinates(1,2),"MMMMRMMRMRRM");
        rovManager.addRover(rover1);
        rovManager.addRover(rover2);
        rovManager.startRovers();

	}
}
