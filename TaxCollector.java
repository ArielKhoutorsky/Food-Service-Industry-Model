import java.util.ArrayList;
import java.util.List;

//collects all the taxes
public class TaxCollector {

	private List<FoodPlace> foodPlaces = new ArrayList<>(); //foodplaces to collect the taxes from

	private double incomeTaxCollected;
	private double salesTaxCollected;

	public TaxCollector(List<FoodPlace> foodPlaces) {
		this.foodPlaces = foodPlaces;
	}

	public List<FoodPlace> getFoodPlaces() {
		return foodPlaces;
	}

	public double getIncomeTaxCollected() {
		return incomeTaxCollected;
	}

	public double getSalesTaxCollected() {
		return salesTaxCollected;
	}

	//collects taxes
	public void collectTax() {
		for(FoodPlace foodPlace: foodPlaces){
			this.salesTaxCollected += foodPlace.getTotalSalesTax(); // the tax collector collects the taxes of all the meals collected by the food places across all the food places //

			for(IncomeTaxPayer payers: foodPlace.getIncomeTaxPayers()){
				this.incomeTaxCollected += payers.calculateIncomeTax(); // the tax collector collects the taxes of all the staff and owners across all the people in all food places //
			}
		}
	}
	
	public String toString() {
		return "TaxCollector: income tax collected: " + incomeTaxCollected + ", sales tax collected: " + salesTaxCollected;
	}
}
