package instructor.sample;

/**
 * This class represents a discount strategy implementation where a flat
 * rate is applied to the cost of a product if and only if a minimum 
 * quantity is purchased. That minimum is configurable.
 * 
 * NOTE: JavaDoc documentation is incomplete. Need to fix!!!
 * 
 * @author  Jim Lombardo
 * @version 1.00
 */
public class QtyDiscount implements DiscountStrategy {
    private double discountRate = 0.10;
    private int minQty = 5;
    
    public QtyDiscount(double rate, int minQty) {
        setDiscountRate(rate);
        setMinQty(minQty);
    }
    
    @Override
    public final double getDiscountAmt(final double unitPrice, final int qty) {
        // needs validation
        if(qty >= minQty) {
            return unitPrice * qty * discountRate;
        } else {
            return 0;
        }
    }

    public final int getMinQty() {
        return minQty;
    }

    public final void setMinQty(final int minQty) {
        // needs validation
        this.minQty = minQty;
    }

    @Override
    public final double getDiscountRate() {
        return discountRate;
    }

    @Override
    public final void setDiscountRate(final double discountRate) {
        // needs validation
        this.discountRate = discountRate;
    }
    
}
