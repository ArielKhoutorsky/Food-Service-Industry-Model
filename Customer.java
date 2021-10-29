

public class Customer  {

	private String name;
	private int  targetTipPct;

	public Customer(String name, int targetTipPct) {
		this.name = name;
		this.targetTipPct = targetTipPct;
	}

	public String getName() {
		return name;
	}

	public int getTargetTipPct() {
		return targetTipPct;
	}

	public String getDescriptiveMessage(FoodPlace foodPlace) {
		return this.name + " dined in " + foodPlace.getName();
	}

	public void dineAndPayCheck(FoodPlace foodPlace, double menuPrice ) {
		Check c = new Check(menuPrice);

		double tippct1 = (foodPlace.getTipPercentage() + getTargetTipPct()) / 2; //the tip % is the average of the food place expected tip and that of the customer//

		c.setTipByPct(tippct1);
		foodPlace.distributeIncomeAndSalesTax(c); // the taxes and tips are properly distributed//

	}
}
