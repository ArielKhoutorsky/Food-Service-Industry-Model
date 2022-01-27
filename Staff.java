public class Staff extends IncomeTaxPayer {

	private int salaryPerHour;
	final private int incomeTaxPercentage = 25;

	//cooks get payed 20/hour, others 10/hour
	public Staff(String name, boolean isCook) {
		super(name);
		if (isCook){
			this.salaryPerHour = 20;
		}
		else{
			this.salaryPerHour = 10;
		}
	}

	public int getSalaryPerHour() {
		return salaryPerHour;
	}

	public int getIncomeTaxPercentage() {
		return incomeTaxPercentage;
	}

	public double workHours(int numHours) {
		setIncome(getIncome() + (numHours * getSalaryPerHour())); // staff is paid hourly //

		return numHours * getSalaryPerHour();
	}

	//income tax is 25 % for staff
	@Override
	public double calculateIncomeTax() {

		double incT = 0.25 * getIncome();

		return incT;
	}

}
