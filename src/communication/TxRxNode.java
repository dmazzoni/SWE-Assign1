package communication;

import core.Node;


public class TxRxNode implements NodeCommunication {
	
	private CommunicationChannel channel;
	private Node parent;
	
	public TxRxNode(CommunicationChannel channel, Node parent) {
		this.channel = channel;
		this.parent = parent;
		channel.subscribe(this);
	}

	@Override
	public void receive(int dest, float data) {
		parent.performReceive(dest, data);
	}

	@Override
	public void send(int dest, float data) {
		channel.broadcast(dest, data);
	}

}
