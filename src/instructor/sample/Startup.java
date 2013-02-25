package instructor.sample;

/**
 *
 * @author Instlogin
 */
public class Startup {


    public static void main(String[] args) {
        CashRegister cr = new CashRegister();
        cr.startNewSale("100", new FakeDatabase(), new ReceiptConsoleOutput());
        cr.addItemToSale("B205", 2);
        cr.addItemToSale("A101", 1);
        cr.endSaleAndOutputReceipt();
    }
}
