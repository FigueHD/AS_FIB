package junit.com;

public class NewYorkFactory implements PayStationFactory {

	@Override
	public RateStrategy createRateStrategy() {
		// TODO Auto-generated method stub
		return new LinearRateStrategy();
	}

	@Override
	public Receipt createReceipt(int parkTime) {
		// TODO Auto-generated method stub
		return new StandardReceipt(parkTime);
	}

}
