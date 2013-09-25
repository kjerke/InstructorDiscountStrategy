package instructor.sample;

/**
 * This interfaces represents the general contract for all implementations 
 * of discount strategy objects.
 * 
 * @author Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public interface DiscountStrategy {
    public abstract double getDiscountAmt(double unitPrice, int qty);
    public abstract double getDiscountRate();
    public abstract void setDiscountRate(double discountRate);
}
