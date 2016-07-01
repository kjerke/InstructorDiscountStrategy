package instructor.sample;

/**
 * This interface represents the general contract for all receipt output 
 * strategy implementations.
 * 
 * NOTE: JavaDoc documentation is incomplete. Need to fix!!!
 * 
 * @author  Jim Lombardo
 * @version 1.00
 */
public interface ReceiptOutputStrategy {
    public abstract void outputReceipt(String data);
    
    public abstract void outputMessage(String msg);
}
