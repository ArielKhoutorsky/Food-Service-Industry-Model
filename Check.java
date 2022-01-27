//a check has a price, a tax and a tip component
public class Check {
	private double menuPrice;
	private double salesTax;
	private double tip;

	public Check(double menuPrice) {
		this.menuPrice = menuPrice;
		this.salesTax = 0.15 * menuPrice;
	}

	public double getMenuPrice() {
		return this.menuPrice;
	}

	public double getSalesTax() {
		return this.salesTax;
	}

	public double getTip() {
		return this.tip;
	}

	public void setTipByPct(double tipPct ) {

		this.tip = (tipPct/100) * this.menuPrice; // the tip is a desired percentage of the price of the meal //
	}
}
