package instructor.sample;

/**
 *
 * @author Instlogin
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
