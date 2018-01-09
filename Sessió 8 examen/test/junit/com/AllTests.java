package junit.com;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestHoursMultaStrategy.class, TestMinutesMultaStrategy.class, 
	TestIntegration.class, TestPayStation.class })
public class AllTests {

}
