import java.util.ArrayList;
import java.util.List;

//a foodstand only has an owner as worker
public class FoodStand extends FoodPlace {

    public FoodStand(String name, double fixedCosts, WorkingOwner owner) {
        super(name,fixedCosts,owner);
    }

    @Override
    public String toString() {
        return "Name of FoodStand: " + this.getName() +
                "\n" + "Owner: " + this.getOwner();
    }

    @Override
    public void workShift(int hours) {
        // no salaried workers so do nothing
    }

    @Override
    public List<IncomeTaxPayer> getIncomeTaxPayers() {
        List<IncomeTaxPayer> ownerTax = (List<IncomeTaxPayer>) new ArrayList<IncomeTaxPayer>();
        ownerTax.add(getOwner()); // adding the owner to the list of taxpayers //
        return ownerTax;

    }

    @Override
    public void distributeIncomeAndSalesTax(Check check) {
        getOwner().setIncome(getOwner().getIncome() + check.getTip() + check.getMenuPrice()); // a working owner gets all the tips //
        setTotalSalesTax(getTotalSalesTax() + check.getSalesTax());
    }

    @Override
    public double getTipPercentage() {
        Owner owner1 = getOwner();
        WorkingOwner ownerWork = (WorkingOwner) owner1;

        return ownerWork.getTargetTipPct();
    }
}
