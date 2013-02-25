package instructor.sample;

/**
 *
 * @author Instlogin
 */
public interface DiscountStrategy {
    public abstract double getDiscountAmt(double unitPrice, int qty);
    public abstract double getDiscountRate();
    public abstract void setDiscountRate(double discountRate);
}
