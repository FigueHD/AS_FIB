package junit.com;

public interface PayStationFactory {
	public RateStrategy createRateStrategy();
	public Receipt createReceipt (int parkTime);

}
