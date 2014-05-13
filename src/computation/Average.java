package computation;

public class Average implements NodeComputation {
	
	Divide divider;
	
	public Average() {
		divider = new Divide();
	}

	@Override
	public float binaryOp(float op1, float op2) {
		return divider.binaryOp(op1, op2);
	}

}
