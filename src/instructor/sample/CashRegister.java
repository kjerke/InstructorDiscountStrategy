package instructor.sample;

/**
 * This class is the main Service class in the program. It delegates all work 
 * to the Receipt class which is the only other class it knows about
 * (Principle of Least Knowledge).
 * 
 * @author  Jim Lombardo
 * @version 1.00
 */
public class CashRegister {
    private static final String ITEM_ERR_MSG = 
            "Item not added to sale because\nprodId not available or qty < 1";
    private static final String PROD_ERR_MSG =
            "Sorry, new sale cancelled because\nan illegal argument"
            + "has been passed\nto CashRegister.startNewSale()";
    
    // No accessors/mutators provided because only CashRegister should have 
    // access to this property.
    private Receipt receipt;
    
    public final void endSaleAndOutputReceipt() {
        receipt.outputReceipt();
    }
    
    public final void addItemToSale(String prodId, int qty) {
            // Validation needed
            if(prodId ==  null || prodId.length() == 0 || qty < 1) {
                receipt.outputMessage(ITEM_ERR_MSG);
                return; // premature exit after log to console
            }
            receipt.addLineItem(prodId, qty);
    }
    
    public final void startNewSale(String custId, ReceiptDataAccessStrategy db, ReceiptOutputStrategy output) {
        // Validation needed.
        if(custId == null || custId.length() == 0
                || db == null || output == null) {
            receipt.outputMessage(PROD_ERR_MSG);
            return; // end prematurely after log to console
        }
        
        receipt = new Receipt(custId, db, output);
    }
    
   
}
