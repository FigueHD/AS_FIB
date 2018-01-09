package junit.com;

public interface PayStationFactory {
	
	public Receipt crearReceipt(int amount);
	
	public RateStrategy crearStrategy();

}
