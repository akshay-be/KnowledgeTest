package elevator.interfaces;

import elevator.impl.enums.ElevatorDirection;
import elevator.impl.enums.ElevatorStatus;

public interface ElevatorFactory {
	public void moveUp();

	public void moveDown();

	public void addNewDestinatoin(Integer destination);

	public ElevatorDirection direction();

	public ElevatorStatus status();

}
