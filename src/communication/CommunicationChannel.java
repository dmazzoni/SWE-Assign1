package communication;

import java.util.Vector;

public class CommunicationChannel {
	
	private Vector<NodeCommunication> nodes;
	
	public CommunicationChannel() {
		nodes = new Vector<NodeCommunication>();
	}
	
	public void subscribe(NodeCommunication node) {
		nodes.add(node);
	}

	public void broadcast(int dest, float data) {
		for (NodeCommunication n : nodes)
			n.receive(dest, data);
	}
}
