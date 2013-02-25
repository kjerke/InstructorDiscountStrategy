
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
    
}
