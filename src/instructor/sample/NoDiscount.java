package instructor.sample;

/**
 * This class simulates a situation where there is no discount for a given
 * product.
 * 
 * NOTE: JavaDoc documentation is incomplete. Need to fix!!!
 * 
 * @author  Jim Lombardo
 * @version 1.00
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
