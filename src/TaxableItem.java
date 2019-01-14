public abstract class TaxableItem implements Item {

    private double taxRate;
    public abstract double getListPrice();

    public TaxableItem(double rate) {
        taxRate = rate;
    }

    public double purchasPrice() {
        return this.getListPrice()*(1+taxRate);
    }
}
