package junit.com;

public class MinutesMultaStrategy implements MultaStrategy {

	
	@Override
	public int calcularImportMulta(int timeBought, int timeExceeded) throws NoEsPotCalcular {
		// TODO Auto-generated method stub
		if(timeBought == 0) throw new NoEsPotCalcular("S'havia d'haver comprat ticket");
		return timeExceeded*5;
	}

}
