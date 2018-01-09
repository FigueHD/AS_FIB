package junit.com;

public class MixedRateStrategy implements RateStrategy {
	
	RateStrategy rs;
	ProgressiveRateStrategy ps = new ProgressiveRateStrategy();
	LinearRateStrategy ls = new LinearRateStrategy();
	
	public MixedRateStrategy(boolean weekend) {
		if(weekend) rs = ps;
		else rs = ls;
	}
	
	public void changeToWeekend() {
		rs = ps;
	}
	
	public void changeToWeekday() {
		rs = ls;
	}

	@Override
	public int calculateTime(int amount) {
		// TODO Auto-generated method stub
		return rs.calculateTime(amount);
	}



}
