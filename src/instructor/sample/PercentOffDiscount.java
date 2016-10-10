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
    public static final String PASS_MSG = "test passed";
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
    
    public static void main(String[] args) {
        DiscountStrategy d = new NoDiscount();
        double discountAmt = d.getDiscountAmt(100, 2);
        if(discountAmt == 0) {
            System.out.println(PASS_MSG);
        } else {
            System.out.println("test failed, got " + discountAmt);
        }
    }
    
}
