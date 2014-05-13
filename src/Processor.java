import communication.TxRxNode;
import computation.*;

public class Processor extends Node {

	private int parkedCars;
	private float averageCars;
	private Add adder;
	private Sub subtracter;
	
	private static final int totalSpots = 500;
	
	public Processor() {
		id = 2;
		commBehaviour = new TxRxNode();
		parkedCars = 0;
		averageCars = 0.0f;
	}

	public void subtractCar() {
		subtracter.binaryOp(parkedCars, 1);
	}

	public void addCar() {
		adder.binaryOp(parkedCars, 1);
	}
}
