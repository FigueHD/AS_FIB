package junit.com;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestStandardReceipt {

	@Test
	public void testStandardReceipt() {
		 Receipt r= new StandardReceipt( 34 );
		 String receiptContent = "----------------------------------";		
		 receiptContent = receiptContent + "\n";
		 receiptContent = receiptContent + "-------- PARKING RECEIPT --------";
		 receiptContent = receiptContent + "\n";
		 receiptContent = receiptContent + "         Value " + 34 + " minutes";
		 receiptContent = receiptContent + "\n";
		 receiptContent = receiptContent + "----------------------------------";
		 
		 assertEquals(receiptContent, r.print()); 
	}

}
