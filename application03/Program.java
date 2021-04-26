package application03;

import devices.ComboDevice;
import devices.ConcretePrinter;
import devices.ConcreteScanner;

public class Program {

	public static void main(String[] args) {
		
		ConcretePrinter cp = new ConcretePrinter("1001");
		String doc1 = "Document one";
		cp.print(doc1);
		cp.processDoc(doc1);
		
		System.out.println();
		ConcreteScanner cs = new ConcreteScanner("1002");
		String doc2 = "Document two";
		System.out.println(cs.scan());
		cs.processDoc(doc2);
		
		System.out.println();
		ComboDevice cd = new ComboDevice("1003");
		String doc3 = "Document three";
		cd.print(doc3);
		System.out.println(cd.scan());
		cd.processDoc(doc3);
		
		
		

	}

}
