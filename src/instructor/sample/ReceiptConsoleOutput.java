
package instructor.sample;

/**
 *
 * @author Instlogin
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
