package com.citrix.navigation.problem;

/**
 * Plateau will be having two coordinates wch indicate lower left and upper right
 * coordinates.
 * 
 * @author AkshayB1
 * 
 */
public class Plateau {

	private Coordinates lowerLeftCoordinates = new Coordinates(0, 0);
	private Coordinates upperRightCoordinates = null;

	public Plateau(int xCoordinate, int yCoordinate) {
		upperRightCoordinates = new Coordinates(xCoordinate, yCoordinate);
	}

	public boolean isWithinBounds(Coordinates coordinates) {
		return this.lowerLeftCoordinates.isOutsideBounds(coordinates)
				&& this.upperRightCoordinates.isWithinBounds(coordinates);
	}
}
