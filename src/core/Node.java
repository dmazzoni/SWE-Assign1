package core;
import communication.NodeCommunication;


public abstract class Node {

	protected int id;
	protected NodeCommunication commBehaviour;
	
	public abstract void performReceive(int dest, float data);
	
	public abstract void performSend(int dest, float data);
}
