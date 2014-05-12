import computation.*;
import java.util.Vector;

public class Processor implements Add, Sub {

	Vector<Monitor> monitors;
	int parkedCars;
	float averageCars;
	
	static final int totalSpots = 500;
	
	public Processor(Vector<Monitor> m) {
		this.monitors = m;
		parkedCars = 0;
		averageCars = 0.0f;
	}

	@Override
	public void sub() {
		parkedCars--;
		notifyMonitors();
	}

	@Override
	public void add() {
		parkedCars++;
		notifyMonitors();
	}
	
	private void notifyMonitors() {
		for (Monitor m : monitors) {
			//TODO
		}
	}
}
