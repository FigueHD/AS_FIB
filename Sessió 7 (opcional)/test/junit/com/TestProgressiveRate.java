package junit.com;

import org.junit.*;
import static org.junit.Assert.*;

/** Testcases for the progressive rate strategy.
 
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
public class TestProgressiveRate {
  RateStrategy rs;

  @Before public void setUp() {
    rs = new ProgressiveRateStrategy();
  }
  
  /** Test a single hour parking */
  @Test public void shouldGive60MinFor150cent() {
    // First hour: $1.5
    assertEquals( 60 /*minutes*/, rs.calculateTime(150) ); 
  }

  /** Test two hours parking */
  @Test public void shouldGive120MinFor350cent() {
    // Two hours: $1.5+2.0
    assertEquals( 2 * 60 /*minutes*/ , rs.calculateTime(350) ); 
  }

  /** Test three hours parking */
  @Test public void shouldGive180MinFor650cent() {
    // Three hours: $1.5+2.0+3.0
    assertEquals( 3 * 60 /*minutes*/ , rs.calculateTime(650) ); 
  }

  /** Test four hours parking */
  @Test public void shouldGive240MinFor950cent() {
    // Three hours: $1.5+2.0+3.0
    assertEquals( 4 * 60 /*minutes*/ , rs.calculateTime(950) ); 
  }
} 
