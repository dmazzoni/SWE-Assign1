package core;
import communication.*;
import computation.*;

public class Processor extends Node {

	private int parkedCars;
	private float averageCars;
	private Add adder;
	private Sub subtracter;
	
	private static final int totalSpots = 500;
	
	public Processor(int id, CommunicationChannel channel) {
		this.id = id;
		commBehaviour = new TxRxNode(channel, this);
		parkedCars = 0;
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

	private void subtractCar() {
		subtracter.binaryOp(parkedCars, 1);
	}

	private void addCar() {
		adder.binaryOp(parkedCars, 1);
	}
}
