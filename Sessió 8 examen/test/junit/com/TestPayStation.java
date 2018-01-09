package junit.com;

import org.junit.*;
import static org.junit.Assert.*;

/** Test cases for the Pay Station system.
 
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
public class TestPayStation {
  PayStation ps;
  /** Fixture for pay station testing. */
  @Before
  public void setUp() {
    ps = new PayStationImpl(new One2OneMultaStrategy());
  }

  /**
   * Entering 5 cents should make the display report 2 minutes 
   * parking time.
  */
  @Test
  public void shouldDisplay2MinFor5Cents() throws IllegalCoinException {
    ps.addPayment( 5 );
    assertEquals( "Should display 2 min for 5 cents", 
                  5 / 5 * 2, ps.readDisplay() ); 
  }

  /**
   * Entering 25 cents should make the display report 10 minutes
   * parking time.
  */
  @Test
  public void shouldDisplay10MinFor25Cents() throws IllegalCoinException {
    ps.addPayment( 25 );
    assertEquals( "Should display 10 min for 25 cents", 
                  25 / 5 * 2, ps.readDisplay() );
    // 25 cent in 5 cent coins each giving 2 minutes parking
  }

  /** 
   * Verify that illegal coin values are rejected.
  */
  @Test(expected=IllegalCoinException.class)
  public void shouldRejectIllegalCoin() throws IllegalCoinException {
    ps.addPayment(17);
  }

  /**
   * Entering 10 and 25 cents should be valid and 
   * return 14 minutes parking 
  */
  @Test
  public void shouldDisplay14MinFor10And25Cents()
          throws IllegalCoinException {
    ps.addPayment( 10 );
    ps.addPayment( 25 );
    assertEquals( "Should display 14 min for 10+25 cents",
                  (10+25) / 5 * 2, ps.readDisplay() );
  }

  /**
   * Buy should return a valid receipt of the 
   * proper amount of parking time
  */
  @Test 
  public void shouldReturnCorrectReceiptWhenBuy() 
          throws IllegalCoinException {
    ps.addPayment(5);
    ps.addPayment(10);
    ps.addPayment(25);
    Receipt receipt;
    receipt = ps.buy();
    assertNotNull( "Receipt reference cannot be null",
                   receipt );
    assertEquals( "Receipt value must be 16 min.",
                  (5+10+25) / 5 * 2 , receipt.value() );
  }
 
  /**
   * Receipts must be able to store parking time values
  */
  @Test 
  public void shouldStoreTimeInReceipt() {
    Receipt receipt = new ReceiptImpl(30);
    assertEquals( "Receipt can store 30 minute value",
                  30, receipt.value() );
  }

  /**
   * Buy for 100 cents and verify the receipt
  */
  @Test 
  public void shouldReturnReceiptWhenBuy100c() 
          throws IllegalCoinException {
    ps.addPayment(10);
    ps.addPayment(10);
    ps.addPayment(10);
    ps.addPayment(10);
    ps.addPayment(10);
    ps.addPayment(25);
    ps.addPayment(25);

    Receipt receipt;
    receipt = ps.buy();
    assertEquals((5*10+2*25) / 5 * 2 , receipt.value() );
  }
  /**
   * Verify that the pay station is cleared after a buy scenario
  */
  @Test 
  public void shouldClearAfterBuy() 
          throws IllegalCoinException {
    ps.addPayment(25);
    ps.buy(); // I do not care about the result
    // verify that the display reads 0
    assertEquals( "Display should have been cleared",
                  0 , ps.readDisplay() );
    // verify that a following buy scenario behaves properly
    ps.addPayment(10); ps.addPayment(25);
    assertEquals( "Next add payment should display correct time",
                  (10+25) / 5 * 2, ps.readDisplay() );
    Receipt r = ps.buy();
    assertEquals( "Next buy should return valid receipt",
                  (10+25) / 5 * 2, r.value() );
    assertEquals( "Again, display should be cleared",
                  0 , ps.readDisplay() );
  }
  /**
   * Verify that cancel clears the pay station
   */
  @Test 
  public void shouldClearAfterCancel() 
          throws IllegalCoinException {
    ps.addPayment(10);
    ps.cancel();
    assertEquals( "Cancel should clear display",
                  0 , ps.readDisplay() );
    ps.addPayment(25);
    assertEquals( "Insert after cancel should work",
                  25/5*2 , ps.readDisplay() );
  }
  
  @Test
  public void shouldCalcularMultaWorks() throws NoEsPotCalcular {
	  assertEquals(6,ps.importMulta(5,6));
  }
  
  @Test
  public void shouldChangeMultaStrategy() {
	  MultaStrategy mstest = new HoursMultaStrategy();
	  ps.changeMultaStrategy(mstest);
	  assertEquals(mstest, ps.getMultaStrategyr());
  }
  
}
