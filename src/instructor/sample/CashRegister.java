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
    private Receipt2 receipt;
    
    /**
     * Ends the sale session and causes receipt to be output to 
     * designated output device. (See Startup class)
     */
    public final void endSaleAndOutputReceipt() {
        receipt.outputReceipt();
    }
    
    /**
     * Delegates job of adding a line item to the receipt. If parameters do not
     * validate, sends error message to designated output.
     * 
     * @param prodId - product id
     * @param qty - quantity of product ordered
     */
    public final void addItemToSale(String prodId, int qty) {
            // Validation needed
            if(prodId ==  null || prodId.length() == 0 || qty < 1) {
                receipt.outputMessage(ITEM_ERR_MSG);
                return; // premature exit
            }
            receipt.addLineItem(prodId, qty);
    }
    
    /**
     * Creates a blank receipt object and delegates job of finding a
     * customer matching an id to the Receipt object. If parameters do not
     * validate, sends error message to designated output.
     * 
     * @param custId - customer id
     * @param db - data source strategy
     * @param output - output strategy
     */
    public final void startNewSale(String custId, ReceiptDataAccessStrategy db, ReceiptOutputStrategy output) {
        // Validation needed.
        if(custId == null || custId.length() == 0
                || db == null || output == null) {
            receipt.outputMessage(PROD_ERR_MSG);
            return; // end prematurely 
        }
        
        receipt = new Receipt2(custId, db, output);
    }
    
   
}
