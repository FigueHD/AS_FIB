package junit.com;

import org.junit.*;
import static org.junit.Assert.*;

/** Integration testing of the configurations of the pay station.
 
   This source code is from the book 
     "Flexible, Reliable Software:
       Using Patterns and Agile Development"
     published 2010 by CRC Press.
   Author: 
     Henrik B Christensen 
     Department of Computer Science
     Aarhus University
   
   Please visit http://www.baerbak.com/ for further information.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
 
       http://www.apache.org/licenses/LICENSE-2.0
 
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

*/
public class TestIntegration {
  private PayStation ps;
  
  /**
   * Integration testing for the linear rate configuration
   */
  @Test 
  public void shouldIntegrateLinearRateCorrectly() 
    throws IllegalCoinException {
    // Configure pay station to be the progressive rate pay station
    ps = new PayStationImpl( new NewYorkFactory() );
    // add $ 2.0: 
    addOneDollar(); addOneDollar();
    Receipt r = ps.buy();
    String receiptContent = "----------------------------------";		
	 receiptContent = receiptContent + "\n";
	 receiptContent = receiptContent + "-------- PARKING RECEIPT --------";
	 receiptContent = receiptContent + "\n";
	 receiptContent = receiptContent + "         Value " + 80 + " minutes";
	 receiptContent = receiptContent + "\n";
	 receiptContent = receiptContent + "----------------------------------";
    assertEquals( "Linear Rate: 2$ should give 80 min ",
                  receiptContent , r.print() );
  }
  /**
   * Integration testing for the progressive rate configuration
   */
  @Test 
  public void shouldIntegrateProgressiveRateCorrectly() 
    throws IllegalCoinException {
    // reconfigure ps to be the progressive rate pay station
    ps = new PayStationImpl( new BostonFactory() );
    // add $ 2.0: 1.5 gives 1 hours, next 0.5 gives 15 min
    addOneDollar(); addOneDollar();
    Receipt r = ps.buy();
    String receiptContent = "----------------------------------";		
	 receiptContent = receiptContent + "\n";
	 receiptContent = receiptContent + "-------- PARKING RECEIPT --------";
	 receiptContent = receiptContent + "\n";
	 receiptContent = receiptContent + "         Value " + 75 + " minutes";
	 receiptContent = receiptContent + "\n";
	 for (int i=0; i<75; i++) {
			receiptContent = receiptContent + "|";
	 }
	 receiptContent = receiptContent + "\n";
	 receiptContent = receiptContent + "----------------------------------";
    assertEquals( "Progressive Rate: 2$ should give 75 min ",
    		receiptContent , r.print());
  }

  private void addOneDollar() throws IllegalCoinException {
    ps.addPayment(25); ps.addPayment(25); 
    ps.addPayment(25); ps.addPayment(25); 
  }
}