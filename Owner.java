public class Owner extends IncomeTaxPayer {

	final private int incomeTaxPct = 10; //owner pays 10% income tax
	private double salaryExpenses;

	//owns a food place
	private FoodPlace foodPlace;

	public Owner(String name) {
		super(name);
	}

	public int getIncomeTaxPct() {
		return incomeTaxPct;
	}

	public double getSalaryExpenses() {
		return salaryExpenses;
	}

	public void setSalaryExpenses(double salaryExpenses) {
		this.salaryExpenses = salaryExpenses;
	}

	public void setFoodPlace(FoodPlace foodPlace) {
		this.foodPlace = foodPlace;
	}

	public FoodPlace getFoodPlace() {
		return foodPlace;
	}


	@Override
	public double calculateIncomeTax() {
		double profit = getIncome() - (getSalaryExpenses() + getFoodPlace().getFixedCosts()); //profits is the difference between revenues and costs
		if (profit > 0 ){
			return 0.1 * profit; // an owner's taxes are 10 percent of his profits //
		}
		else{
			return 0; //no taxes if profits are negative
		}
	}
}
