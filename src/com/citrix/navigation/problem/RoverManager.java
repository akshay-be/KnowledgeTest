package com.citrix.navigation.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class RoverManager {

	private List<Rover> listRover = null;

	private static RoverManager mySelf = new RoverManager();

	private Plateau plateau;

	private RoverManager() {
		listRover = new ArrayList<Rover>();
	}

	private static ReentrantLock plateauLock = new ReentrantLock();
	
	private static CountDownLatch latch = new CountDownLatch(0);

	public static RoverManager getInstance() {
		return mySelf;
	}

	public void setPlateau(Plateau plateau) {
		if(this.plateau==null){
			this.plateau = plateau;
		}else{
			throw new PlateauChangeException("Soory.. Cant change platue");
		}
	}

	public boolean addRover(Rover rover) {
		if(latch.getCount()==0){
			Coordinates currentCordinate = rover.currentLocation();
			if (isCordinateAvilable(currentCordinate)) {
				listRover.add(rover);
			}
		}
		return false;
	}
	
	public void startRovers(){
		System.out.println("Strating rovers...");
		if(latch.getCount()>0){
			throw new RoverException("Rovers already running....");
		}else {
			latch = new CountDownLatch(listRover.size());
			System.out.println("Latch count : "+latch.getCount());
			for (Rover rover : listRover) {
				Thread t = new Thread(rover);
				t.start();
			}
		}
	}
	
	
	private boolean isCordinateAvilable(Coordinates cordinate) {
		boolean isAvilable = true;
		try {
			plateauLock.lock();
			for (Rover rover : listRover) {
				Coordinates existingRoverCordinate = rover.currentLocation();
				if (existingRoverCordinate.equals(cordinate)) {
					isAvilable = false;
					break;
				}
			}
		} finally {
			plateauLock.unlock();
		}
		return isAvilable;
	}

	boolean isWithinBounds(Coordinates cordinate) {
		return plateau.isWithinBounds(cordinate);
	}

	public synchronized Coordinates moveRover(Coordinates positionAfterMove) {
		boolean isAvilable = isCordinateAvilable(positionAfterMove);

		while (!isAvilable) {
			try {
				wait();
				isAvilable = isCordinateAvilable(positionAfterMove);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		if (isAvilable) {
			positionAfterMove.newCoordinatesForMove(positionAfterMove.getX(),positionAfterMove.getY());
			notify();
		}

		return positionAfterMove;
	}

	public static CountDownLatch getLatch() {
		return latch;
	}

}
