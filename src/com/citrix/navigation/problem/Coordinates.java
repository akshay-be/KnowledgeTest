package com.citrix.navigation.problem;

/**
 * 
 * @author AkshayB1
 * 
 */
public class Coordinates {

	/** X-Axis representation */
	private int xCoordinate;
	
	/** Y-Axis representation */
	private int yCoordinate;

	public Coordinates(int xCoordinate, int yCoordinate) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}

	/**
	 * API to Provide new coordinates of updated values.
	 * @param xCoordinateStepValue
	 * @param yCoordinateStepValue
	 * @return
	 */
	public void newCoordinatesForMove(int xCoordinateStepValue, int yCoordinateStepValue) {
		this.xCoordinate = xCoordinateStepValue;
		this.yCoordinate = yCoordinateStepValue;
	}
	
	

	public boolean isWithinBounds(Coordinates coordinates) {
		return isXCoordinateWithinBounds(coordinates.xCoordinate)
				&& isYCoordinateWithinBounds(coordinates.yCoordinate);
	}

	public boolean isOutsideBounds(Coordinates coordinates) {
		return isXCoordinateInOutsideBounds(coordinates.xCoordinate)
				&& isYCoordinateInOutsideBounds(coordinates.yCoordinate);
	}

	private boolean isXCoordinateInOutsideBounds(int xCoordinate) {
		return xCoordinate >= this.xCoordinate;
	}

	private boolean isYCoordinateInOutsideBounds(int yCoordinate) {
		return yCoordinate >= this.yCoordinate;
	}

	private boolean isYCoordinateWithinBounds(int yCoordinate) {
		return yCoordinate <= this.yCoordinate;
	}

	private boolean isXCoordinateWithinBounds(int xCoordinate) {
		return xCoordinate <= this.xCoordinate;
	}
	
	@Override
	public String toString() {
		return "x=" + xCoordinate + ", y="+ yCoordinate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + xCoordinate;
		result = prime * result + yCoordinate;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinates other = (Coordinates) obj;
		if (xCoordinate != other.xCoordinate)
			return false;
		if (yCoordinate != other.yCoordinate)
			return false;
		return true;
	}
	
	public int getX() {
		return xCoordinate;
	}

	public int getY() {
		return yCoordinate;
	}
}
