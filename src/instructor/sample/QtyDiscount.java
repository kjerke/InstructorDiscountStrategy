package instructor.sample;

/**
 *
 * @author Instlogin
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
