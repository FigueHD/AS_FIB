package junit.com;

public class NYFactory implements PayStationFactory {

	@Override
	public RateStrategy crearRateStrategy() {
		// TODO Auto-generated method stub
		return new LinearRateStrategy();
	}

	@Override
	public Receipt crearReceipt(int amount) {
		// TODO Auto-generated method stub
		return new StandardReceipt(amount);
	}

}
