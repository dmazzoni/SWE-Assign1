package communication;

public interface NodeCommunication {

	public void receive(int dest, float data);
	public void send(int dest, float data);
}
