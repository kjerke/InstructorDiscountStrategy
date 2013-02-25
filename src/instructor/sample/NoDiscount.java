package instructor.sample;

/**
 *
 * @author Instlogin
 */
public class NoDiscount implements DiscountStrategy {
    private double discountRate = 0;

    @Override
    public final double getDiscountAmt(double unitPrice, int qty) {
        return 0;
    }

    @Override
    public final double getDiscountRate() {
        return discountRate;
    }

    @Override
    public final void setDiscountRate(double discountRate) {
        this.discountRate = 0;
    }
    
}
