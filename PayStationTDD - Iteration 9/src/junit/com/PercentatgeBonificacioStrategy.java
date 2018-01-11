package junit.com;

public class PercentatgeBonificacioStrategy implements BonificacioStrategy {
	

	
	private double percentatge = 0.1;
	
	@Override
	public int calcularBonificacio(int timeBought) {
		return (int) (timeBought*percentatge); 
	}
	
	public void changePercentatge(double percentatge) {
		this.percentatge = percentatge;
	}

}
