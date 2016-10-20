package learn.elevator.interfaces;

import learn.elevator.impl.enums.ElevatorDirection;
import learn.elevator.impl.enums.ElevatorStatus;

public interface ElevatorFactory {
	public void moveUp();

	public void moveDown();

	public void addNewDestinatoin(Integer destination);

	public ElevatorDirection direction();

	public ElevatorStatus status();

}
