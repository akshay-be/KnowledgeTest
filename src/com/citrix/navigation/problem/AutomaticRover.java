package com.citrix.navigation.problem;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author AkshayB1
 *
 */
public class AutomaticRover implements Rover {

	private String name;
	private Coordinates currentCoordinates;
    private Direction currentDirection;
    private String commandString;
    private RoverManager roverManager = RoverManager.getInstance();
	
	public AutomaticRover(String name,Direction direction, Coordinates coordinates,String commandString) {
		this.name = name;
		this.currentDirection = direction;
        this.currentCoordinates = coordinates;
        this.commandString = commandString;
    }

	@Override
	public void run() {
		roverRun();
	}
	@Override
    public void roverRun() {
       System.out.println("commandString");
		List<Command> roverCommands = new StringParserUtil(commandString).toCommands();
        for (Command command : roverCommands) {
        	System.out.print(" Before "+currentLocation());
        	command.execute(this);
        	System.out.print(" "+command);
        	System.out.print(" After "+currentLocation());
        	System.out.println();
        }
        roverManager.getLatch().countDown();
        System.out.println(name+" competed final status "+currentPosition());
    }

	@Override
    public String currentPosition() {
        return "["+currentCoordinates.toString() + "  " + currentDirection.toString()+"]";
    }

	@Override
    public void turnRight() {
        currentDirection = currentDirection.right();
    }

	@Override
    public void turnLeft() {
        currentDirection = currentDirection.left();
    }

	@Override
    public void move() {
		int newX = currentCoordinates.getX();
		int newY = currentCoordinates.getY();
		if (currentDirection.equals(Direction.North)) {
			newX++;
		} else if (currentDirection.equals(Direction.South)) {
			newX--;
		} else if (currentDirection.equals(Direction.East)) {
			newY++;
		} else if (currentDirection.equals(Direction.West)) {
			newY--;
		}
		Coordinates positionAfterMove = new Coordinates(newX, newY);
		if (roverManager.isWithinBounds(positionAfterMove)) {
			currentCoordinates = roverManager.moveRover(positionAfterMove);
		}else{
			//TODO not in bounds.... Just ignoring commad.
		}

    }

	@Override
	public Coordinates currentLocation() {
		return currentCoordinates;
	}

	
}
