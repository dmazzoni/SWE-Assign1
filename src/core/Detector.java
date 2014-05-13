package core;

import communication.*;

public class Detector extends Node {
	
	public Detector(int id, CommunicationChannel channel) {
		this.id = id;
		commBehaviour = new TxNode(channel);
	}

	public void carEnters() {
		performSend(2, 1);
	}
	
	public void carExits() {
		performSend(2, -1);
	}

	@Override
	public void performReceive(int dest, float data) {
		// Do nothing
	}

	@Override
	public void performSend(int dest, float data) {
		commBehaviour.send(dest, data);
	}
}
