
package instructor.sample;

/**
 * This class represents a output strategy implementation where the output is
 * sent to the console.
 * 
 * NOTE: JavaDoc documentation is incomplete. Need to fix!!! Also need to 
 * remove magic number violations.
 * 
 * @author  Jim Lombardo
 * @version 1.00
 */
public class ReceiptConsoleOutput implements ReceiptOutputStrategy {

    @Override
    public void outputReceipt(String data) {
        System.out.println(data);
    }

    @Override
    public void outputMessage(String msg) {
        System.out.println("\n========== Data Entry Error ==========");
        System.out.println(msg);
        System.out.println("=======================================\n");
    }
    
}
