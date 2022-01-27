public abstract class IncomeTaxPayer {

	private static int currentMaxTaxID;
	private int  taxID;
	private String  name;
	private double  income;

	public IncomeTaxPayer(String name){
		this.name = name;
		this.taxID =  currentMaxTaxID;
		currentMaxTaxID++;
	}

	public static int getCurrentMaxTaxID() {
		return currentMaxTaxID;
	}

	public int getTaxID() {
		return taxID;
	}

	public String getName() {
		return name;
	}

	public double getIncome() {
		return this.income;
	}

	public void setIncome( double income) {
		this.income = income;
	}

	public String toString() {
		return "  " + taxID + " " + name + " income " + income ;
	}

	//compares two income tax payers
	public boolean equals(Object obj) {
		if (!(obj instanceof IncomeTaxPayer)){
			return false;
		}
		IncomeTaxPayer compareObj = (IncomeTaxPayer) obj;

		if ((compareObj.getTaxID()) == (this.taxID)){
			return true;
		}
		return false;
	}

	public abstract double calculateIncomeTax();
}
