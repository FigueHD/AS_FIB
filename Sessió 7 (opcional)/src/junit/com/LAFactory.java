package junit.com;

public class LAFactory implements PayStationFactory {

	@Override
	public Receipt crearReceipt(int amount) {
		// TODO Auto-generated method stub
		return new ReceiptImpl(amount);
	}

	@Override
	public RateStrategy crearStrategy() {
		// TODO Auto-generated method stub
		return new MixedRateStrategy(false);
	}

}
