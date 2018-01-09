package junit.com;

public class HoursMultaStrategy implements MultaStrategy {

	@Override
	public int calcularImportMulta(int timeBought, int timeExceeded) throws NoEsPotCalcular {
		if(timeExceeded < 60) throw new NoEsPotCalcular("El temps excedit es menor a 60 minuts");
		if(timeExceeded > (3 * timeBought)) throw new NoEsPotCalcular("El temps excedit es menor a 60 minuts");
		return timeExceeded / 60 * 500;
	}

}
