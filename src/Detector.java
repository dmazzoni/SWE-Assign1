
public class Detector {
	
	Processor processingUnit;
	
	public Detector(Processor p) {
		processingUnit = p;
	}

	public void carEnters() {
		processingUnit.add();
	}
	
	public void carExits() {
		processingUnit.sub();
	}
}
