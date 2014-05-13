package computation;

public class Divide implements NodeComputation {

	@Override
	public float binaryOp(float op1, float op2) {
		return op1 / op2;
	}

}
