package junit.com;

public interface PayStationFactory {
	
	public RateStrategy crearRateStrategy();
	
	public Receipt crearReceipt(int amount);
}
