package core;

import communication.CommunicationChannel;

public class Simulator {
	
	private CommunicationChannel channel;
	private Detector detector;
	private Processor processor;
	private Monitor averageMonitor;
	private Monitor freeSlotsMonitor;

	public Simulator() {
		simulate();
	}
	
	private void simulate() {
		channel = new CommunicationChannel();
		detector = new Detector(1, channel);
		processor = new Processor(2, channel);
		averageMonitor = new Monitor(3, channel);
		freeSlotsMonitor = new Monitor(4, channel);
	}
	
	public static void main(String[] args) {
		new Simulator();
	}
}
