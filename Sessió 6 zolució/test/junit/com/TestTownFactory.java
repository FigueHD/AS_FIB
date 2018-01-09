package junit.com;

public class TestTownFactory implements PayStationFactory {

	@Override
	public RateStrategy createRateStrategy() {
		// TODO Auto-generated method stub
		return new One2OneRateStrategy();
	}

	@Override
	public Receipt createReceipt(int parkTime) {
		// TODO Auto-generated method stub
		return new StandardReceipt(parkTime);
	}

}
