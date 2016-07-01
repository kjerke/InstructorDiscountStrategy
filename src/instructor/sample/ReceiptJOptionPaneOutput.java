
package instructor.sample;

import javax.swing.JOptionPane;

/**
 * This class represents an output strategy implementation where the output 
 * is sent to a swing GUI.
 * 
 * NOTE: JavaDoc documentation is incomplete. Need to fix!!!
 * 
 * @author  Jim Lombardo
 * @version 1.00
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
