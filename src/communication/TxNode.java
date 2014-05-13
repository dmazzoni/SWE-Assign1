package communication;

public class TxNode implements NodeCommunication {
	
	private CommunicationChannel channel;
	
	public TxNode(CommunicationChannel channel) {
		this.channel = channel;
		channel.subscribe(this);
	}

	@Override
	public void receive(int dest, float data) {
		// Do nothing
	}

	@Override
	public void send(int dest, float data) {
		channel.broadcast(dest, data);
	}
}
