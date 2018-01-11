package junit.com;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestIntegration.class, TestMinutsBonificacio.class, TestNoBonificacio.class, TestPayStation.class,
		TestPercentatgeBonificacio.class })
public class AllTests {

}
