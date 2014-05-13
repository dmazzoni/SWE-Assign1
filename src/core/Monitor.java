package core;

import communication.*;

public class Monitor extends Node {

	public Monitor(int id, CommunicationChannel channel) {
		this.id = id;
		commBehaviour = new RxNode(channel, this);
	}

	@Override
	public void performReceive(int dest, float data) {
		if (dest != id)
			return;
		
		display(data);
	}

	@Override
	public void performSend(int dest, float data) {
		// Do nothing
	}
	
	private void display(float data) {
		System.out.println("Monitor " + id + ": " + data);
	}

}
