package junit.com;

public class BostonFactory implements PayStationFactory {

	@Override
	public RateStrategy createRateStrategy() {
		// TODO Auto-generated method stub
		return new ProgressiveRateStrategy();
	}

	@Override
	public Receipt createReceipt(int parkTime) {
		// TODO Auto-generated method stub
		return new BarCodeReceipt(parkTime);
	}

}
