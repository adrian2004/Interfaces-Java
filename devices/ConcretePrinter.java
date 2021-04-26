package devices;

public class ConcretePrinter extends Device implements Printer{

	public ConcretePrinter(String serialNumber) {
		super(serialNumber);
	}

	@Override
	public void print(String doc) {
		System.out.println(doc);
	}

	@Override
	public void processDoc(String doc) {
		System.out.println("Document processed: " + doc);
	}

}
