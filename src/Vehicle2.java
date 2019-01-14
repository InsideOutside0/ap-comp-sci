public class Vehicle2 extends TaxableItem {

    private double dealerCost;
    private double dealerMarkup;

    public Vehicle2(double dealerCost, double dealerMarkup, double rate) {
        super(rate);
        this.dealerCost = dealerCost;
        this.dealerMarkup = dealerMarkup;

    }

    public void changeMarkup(double m) {
        this.dealerMarkup = m;
    }

    public double getListPrice() {
        return dealerCost+dealerMarkup;
    }

}
