package instructor.sample;

/**
 * This class represents a discount strategy implementation where a flat
 * rate is applied to the cost of a product.
 * 
 * NOTE: JavaDoc documentation is incomplete. Need to fix!!!
 * 
 * @author  Jim Lombardo
 * @version 1.00
 */
public class PercentOffDiscount implements DiscountStrategy {
    private double discountRate = 0.10;
    
    public PercentOffDiscount(double rate) {
        setDiscountRate(rate);
    }
    
    @Override
    public final double getDiscountAmt(double unitPrice, int qty) {
        // needs validation
        return unitPrice * qty * discountRate;
    }

    @Override
    public final double getDiscountRate() {
        return discountRate;
    }

    @Override
    public final void setDiscountRate(double discountRate) {
        // validation needed here
        this.discountRate = discountRate;
    }
    
}
