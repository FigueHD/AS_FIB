package junit.com;

public class NoBonificacioStrategy implements BonificacioStrategy {

	@Override
	public int calcularBonificacio(int timeBought) {
		return 0;
	}

}
