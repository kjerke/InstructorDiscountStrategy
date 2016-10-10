package instructor.sample;

/**
 * This interface represents the general contract for creating all 
 * data access strategy implementations.
 * 
 * NOTE: JavaDoc documentation is incomplete. Need to fix!!!
 * 
 * @author  Jim Lombardo
 * @version 1.00
 */
public interface ReceiptDataAccessStrategy {

    public abstract Customer findCustomer(final String custId);

    public abstract Product findProduct(final String prodId);

}
