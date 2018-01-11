package junit.com;

public class MinutsBonificacioStrategy implements BonificacioStrategy {

	private int minutsABonificar = 5;
	
	@Override
	public int calcularBonificacio(int timeBought) throws NoEsPotBonificar {
		if(MinutsCompratsInferiorMinutsABonificar(timeBought)) throw new NoEsPotBonificar("No es pot bonificar");
		return timeBought / minutsABonificar;
	}

	private boolean MinutsCompratsInferiorMinutsABonificar(int timeBought) {
		return minutsABonificar > timeBought;
	}
	
	public void changeMinutsABonificar(int minutsABonificar){
		this.minutsABonificar = minutsABonificar;		
	}

}
