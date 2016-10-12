package com.citrix.navigation.problem;

public class Plateau {

	private Coordinates topRightCoordinates = new Coordinates(0, 0);
	private Coordinates bottomLeftCoordinates = new Coordinates(0, 0);

	public Plateau(int rightXCoordinate, int rightYCoordinate) {
		topRightCoordinates = topRightCoordinates.newCoordinatesFor(rightXCoordinate, rightYCoordinate);
	}

	public boolean isWithinBounds(Coordinates coordinates) {
		return this.bottomLeftCoordinates.isOutsideBounds(coordinates)
				&& this.topRightCoordinates.isWithinBounds(coordinates);
	}
}
