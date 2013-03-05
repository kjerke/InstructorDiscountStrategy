
package instructor.sample;

import javax.swing.JOptionPane;

/**
 *
 * @author Instlogin
 */
public class ReceiptJOptionPaneOutput implements ReceiptOutputStrategy {

    @Override
    public void outputReceipt(String data) {
        JOptionPane.showMessageDialog(null, data);
    }
 
    @Override
    public void outputMessage(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
   
}
