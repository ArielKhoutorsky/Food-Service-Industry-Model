import java.util.ArrayList;
import java.util.List;

public class FastFood extends FoodPlace {

    private List<Staff> staff = new ArrayList<>();

    public FastFood(String name, double fixedCosts, Owner owner, List<Staff> staff) {
        super(name,fixedCosts,owner);

        for (int i =0; i<staff.size(); i++){
            this.staff.add(i , staff.get(i));
        }
    }

    public List<Staff> getStaff() {
        return staff;
    }

    //workers are paid based on work hours and wage
    @Override
    public void workShift(int hours) {
        double sum = 0;
        for (int i = 0; i < this.staff.size() ; i++){
            Staff temp = this.staff.get(i);
            sum+= temp.workHours(hours);
            this.staff.set(i,temp);
        }
        getOwner().setSalaryExpenses(getOwner().getSalaryExpenses() + sum); // owner's salary expenses are changed based on the working hours of the employees//
    }

    //returns a list of all the staff and owner
    @Override
    public List<IncomeTaxPayer> getIncomeTaxPayers() {
        List<IncomeTaxPayer> taxPayers = new ArrayList<>();
        for (int i = 0; i < this.staff.size() ; i++){
            taxPayers.add(i, this.staff.get(i));
        }
        taxPayers.add(getOwner());
        return taxPayers; 
    }

    //distribution of the customer's check
    @Override
    public void distributeIncomeAndSalesTax(Check check) {
        getOwner().setIncome(getOwner().getIncome() + check.getMenuPrice()); // the cost of the meal goes towards the owner's income 
        double tipSplit = check.getTip() / this.staff.size();
        for (int i = 0; i < this.staff.size() ; i++){
            Staff temp = this.staff.get(i);
            temp.setIncome(temp.getIncome() + tipSplit); // the tip is split equally between each staff member //
            this.staff.set(i , temp);
        }
        setTotalSalesTax(check.getSalesTax());
    }

    //no tips for fast food
    @Override
    public double getTipPercentage() {
        return 0;
    }

}
