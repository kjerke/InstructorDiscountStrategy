package instructor.sample;

/**
 * This is the startup class for the program. Note that currently it
 * provides hard coded information about the customer and items ordered. In 
 * the future we'll use a GUI for this.
 * <P>
 * Also note that the principal of least knowledge is mostly observed by 
 * delegating all the work to the CashRegister object. 
 * 
 * However, the concrete
 * FakeDatabase and ReceiptConsoleOutput classes are also references, which
 * represents additional knowledge that a startup class really shouldn't have.
 * And these are hard dependencies as well. In the future we'll learn how to
 * use a concept called "Dependency Injection" which uses a configuration file
 * to solve this problem.
 * 
 * @author  Jim Lombardo
 * @version 1.00
 */
public class Startup {
    /**
     * Starts program
     * @param args - not used
     */
    public static void main(String[] args) {
        CashRegister cr = new CashRegister();
        
        // Customer #1 sale
        cr.startNewSale("100", new FakeDatabase(), new ReceiptConsoleOutput());
        cr.addItemToSale("B205", 2);
        cr.addItemToSale("A101", 1);
        cr.endSaleAndOutputReceipt();
        
        // Customer #2 sale
        cr.startNewSale("200", new FakeDatabase(), new ReceiptConsoleOutput());
        cr.addItemToSale("C222", 4);
        cr.addItemToSale("B205", 6);
        cr.endSaleAndOutputReceipt();
    }
}
