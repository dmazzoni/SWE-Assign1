package computation;

public class Sub implements NodeComputation {

	@Override
	public int binaryOp(int op1, int op2) {
		return op1 - op2;
	}
}
