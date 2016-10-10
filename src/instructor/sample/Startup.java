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
        PosTerminal pos = new PosTerminal();
        ReceiptDataAccessStrategy db = new InMemoryDataAccess();
        
        // Customer #1 sale
        pos.startNewSale("", db, new ReceiptConsoleOutput());
        pos.addItemToSale("B205", 2);
        pos.addItemToSale("A101", 1);
        pos.endSaleAndOutputReceipt();
        
        // Customer #2 sale
        pos.startNewSale("200", new InMemoryDataAccess(), new ReceiptConsoleOutput());
        pos.addItemToSale("C222", 4);
        pos.addItemToSale("B205", 6);
        pos.endSaleAndOutputReceipt();
    }
}
