
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
    
}
