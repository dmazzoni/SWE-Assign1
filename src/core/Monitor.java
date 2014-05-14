package core;

import javax.swing.JLabel;

import communication.*;

public class Monitor extends Node {
	
	private JLabel label;

	public Monitor(int id, CommunicationChannel channel, JLabel label) {
		this.id = id;
		commBehaviour = new RxNode(channel, this);
		this.label = label;
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
		label.setText(data + "");
	}

}
