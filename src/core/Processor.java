package core;
import communication.*;
import computation.*;

public class Processor extends Node {

	private int parkedCars;
	private int traffic;
	private int hours;
	private float averageCars;
	private Add adder;
	private Sub subtracter;
	private Average avg;
	
	protected static final int totalSlots = 500;
	
	public Processor(int id, CommunicationChannel channel) {
		this.id = id;
		commBehaviour = new TxRxNode(channel, this);
		adder = new Add();
		subtracter = new Sub();
		avg = new Average();
		parkedCars = 0;
		traffic = 0;
		hours = 0;
		averageCars = 0.0f;
	}

	@Override
	public void performReceive(int dest, float data) {
		if (dest != id)
			return;
		
		if (data == 1.0)
			addCar();
		else if (data == -1.0)
			subtractCar();
	}

	@Override
	public void performSend(int dest, float data) {
		commBehaviour.send(dest, data);
	}
	
	public void hourPassed() {
		hours = (int) adder.binaryOp(hours, 1);
		averageCars = avg.binaryOp(traffic, hours);
		performSend(3, averageCars);
	}
	
	private void subtractCar() {
		if (parkedCars > 0) {
			parkedCars = (int) subtracter.binaryOp(parkedCars, 1);
			updateFreeSlots();
		}
	}

	private void addCar() {
		parkedCars = (int) adder.binaryOp(parkedCars, 1);
		updateFreeSlots();
	}
	
	private void updateFreeSlots() {
		int freeSlots = (int) subtracter.binaryOp(totalSlots, parkedCars);
		traffic = (int) adder.binaryOp(traffic, 1);
		performSend(4, freeSlots < 0 ? 0 : freeSlots);
	}
}
