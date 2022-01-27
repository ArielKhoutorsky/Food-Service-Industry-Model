import java.util.ArrayList;
import java.util.List;

//restaurant has cooks and servers
public class Restaurant extends FoodPlace {

	private Staff cook;
	private Server server;

	public Restaurant(String name, double fixedCosts, Owner owner, Staff cook, Server server) {
		super(name,fixedCosts,owner);
		this.cook = cook;
		this.server = server;
	}

	public Staff getCook() {
		return cook;
	}

	public Server getServer() {
		return server;
	}

	@Override
	public String toString() {
		return "Name of restaurant: " + this.getName() +
				"\n" + "Owner: " + this.getOwner() +
				"\n" + "Cook: " + cook +
				"\n" + "Server: " + server;
	}

	//simulates a work shift for the restaurant
	@Override
	public void workShift(int hours) {
		this.cook.setIncome(this.cook.getIncome() + cook.getSalaryPerHour()*hours); //sets cook's income
		this.server.setIncome(this.server.getIncome() + server.getSalaryPerHour()*hours); // sets server's income //
		getOwner().setSalaryExpenses(getOwner().getSalaryExpenses() + (server.getSalaryPerHour()*hours) + (cook.getSalaryPerHour()*hours)); // the owner expenses are the staff's wages //
	}

	//a list of the members of the food place 
	@Override
	public List<IncomeTaxPayer> getIncomeTaxPayers() {
		ArrayList<IncomeTaxPayer> l = new ArrayList<IncomeTaxPayer>();
		IncomeTaxPayer o = (IncomeTaxPayer) getOwner();
		IncomeTaxPayer c = (IncomeTaxPayer) getCook();
		IncomeTaxPayer s = (IncomeTaxPayer) getServer();
		l.add(o);
		l.add(c);
		l.add(s); 
		return l;
	}

	@Override
	public void distributeIncomeAndSalesTax(Check check) {
		getOwner().setIncome(getOwner().getIncome() + check.getMenuPrice()); // the owner's income is the price of the meal //
		this.cook.setIncome(this.cook.getIncome() + 0.2 * check.getTip()); // the cook gets 20% of the tips //
		this.server.setIncome(this.server.getIncome() + 0.8 * check.getTip()); // the server gets 80% of the tips //
		setTotalSalesTax(check.getSalesTax());
	}

	@Override
	public double getTipPercentage() {
		return this.server.getTargetTipPct(); //tip desired by the server
	}

}
