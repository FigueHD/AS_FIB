package junit.com;

public class BostonFactory implements PayStationFactory {

	@Override
	public RateStrategy crearRateStrategy() {
		// TODO Auto-generated method stub
		return new ProgressiveRateStrategy();
	}

	@Override
	public Receipt crearReceipt(int amount) {
		// TODO Auto-generated method stub
		return new BarCodeReceipt(amount);
	}

}
