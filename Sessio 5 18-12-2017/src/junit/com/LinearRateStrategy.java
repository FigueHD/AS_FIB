package junit.com;

public class LinearRateStrategy implements RateStrategy {

	@Override
	public int calcularTarifa(int amount) {
		// TODO Auto-generated method stub
		return amount / 5 * 2;
	}

}
