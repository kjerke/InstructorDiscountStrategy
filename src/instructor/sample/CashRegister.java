package instructor.sample;

/**
 * Notice how simple this version is ... Principle of Least Knowledge
 * @author Instlogin
 */
public class CashRegister {
    private Receipt receipt;
    
    public final void endSaleAndOutputReceipt() {
        receipt.outputReceipt();
    }
    
    public final void addItemToSale(String prodId, int qty) {
            receipt.addLineItem(prodId, qty);
    }
    
    public final void startNewSale(String custId, ReceiptDataAccessStrategy db, ReceiptOutputStrategy output) {
        receipt = new Receipt(custId, db, output);
    }
    
   
}
