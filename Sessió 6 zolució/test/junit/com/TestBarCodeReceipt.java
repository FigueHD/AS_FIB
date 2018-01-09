package junit.com;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class TestBarCodeReceipt {

	@Test
	public void testBarcodeReceipt() {
		 Receipt r= new BarCodeReceipt( 34 );
		 String receiptContent = "----------------------------------";		
		 receiptContent = receiptContent + "\n";
		 receiptContent = receiptContent + "-------- PARKING RECEIPT --------";
		 receiptContent = receiptContent + "\n";
		 receiptContent = receiptContent + "         Value " + 34 + " minutes";
		 receiptContent = receiptContent + "\n";
		 for (int i=0; i<34; i++) {
				receiptContent = receiptContent + "|";
		 }
		 receiptContent = receiptContent + "\n";
		 receiptContent = receiptContent + "----------------------------------";
		 assertEquals(receiptContent, r.print()); 
	}

}
