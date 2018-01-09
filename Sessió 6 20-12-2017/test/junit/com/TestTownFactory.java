package junit.com;

public class TestTownFactory implements PayStationFactory {

	@Override
	public RateStrategy crearRateStrategy() {
		// TODO Auto-generated method stub
		return new One2OneRateStrategy();
	}

	@Override
	public Receipt crearReceipt(int amount) {
		// TODO Auto-generated method stub
		return new StandardReceipt(amount);
	}

}
