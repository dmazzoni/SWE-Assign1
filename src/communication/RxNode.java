package communication;

import core.Node;

public class RxNode implements NodeCommunication {
	
	private Node parent;
	
	public RxNode(CommunicationChannel channel, Node parent) {
		this.parent = parent;
		channel.subscribe(this);
	}

	@Override
	public void receive(int dest, float data) {
		parent.performReceive(dest, data);
	}

	@Override
	public void send(int dest, float data) {
		// Do nothing
	}
}
