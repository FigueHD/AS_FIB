package junit.com;

public class ProgressiveTateStrategy implements RateStrategy {

	@Override
	public int calcularTarifa(int amount) {
	    int time = 0;
	    if ( amount >= 150+200 ) { // from 2nd hour onwards
	      amount -= 350;
	      time = 120 /*min*/ + amount / 5;
	    } else if ( amount >= 150 ) { // from 1st to 2nd hour
	      amount -= 150;
	      time = 60 /*min*/ + amount * 3 / 10;
	    } else { // up to 1st hour
	      time = amount * 2 / 5;
	    }
	    return time;
	  }

}
