package instructor.sample;

import edu.wctc.jgl.prettyformat.JustifyDirection;
import edu.wctc.jgl.prettyformat.TableFormatter;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class has the same responsibility as Receipt.java, but uses the 
 * PrettyFormat library to format output.
 * 
 * @author  Jim Lombardo
 * @version 1.00
 */
public class Receipt2 {
    private final String CUST_INPUT_ERR = 
            "Customer id is a required field. Please try again.";
    private final String CUST_NOT_FOUND_ERR =
            "No customer found for that id. Please try again.";
    private final String DATA_SRC_ERR =
            "Data source is a required field";
    private final String OUTPUT_ERR =
            "An output strategy is required";
    private ReceiptDataAccessStrategy db; // strategy component (DIP compliant)
    private static int receiptNo = 0; // global counter
    private Date receiptDate;
    private Customer customer; // strategy component
    private LineItem[] lineItems;
    // strategy component (DIP compliant)
    private ReceiptOutputStrategy output;
    private String dateFormat = "M/d/yyyy hh:mm a"; // default

    /**
     * Custom constructor finds and creates Customer, assigns receipt number
     * and date.
     * 
     * @param custId - customer id. Validated by helper method. Error messages
     * send to designated output strategy.
     * 
     * @param db - data source strategy
     * @param output - output strategy
     */
    public Receipt2(String custId, ReceiptDataAccessStrategy db, ReceiptOutputStrategy output) {
        this.setDb(db);
        this.output = output;
        this.customer = findCustomer(custId);
        receiptNo++;
        lineItems = new LineItem[0];
        receiptDate = new Date();
    }
    
    private final Customer findCustomer(final String custId) {
        if(custId == null || custId.length() == 0) {
            output.outputMessage(CUST_INPUT_ERR);
        }
        
        Customer cust = db.findCustomer(custId);
        if(cust == null) {
            output.outputMessage(CUST_INPUT_ERR);
        }
        return cust;
    }    
    
    /**
     * Gets the subtotal of all purchased items before the discount applied.
     * @return subtotal of purchased items before discount.
     */
    public final double getTotalBeforeDiscount() {
        double total = 0.0;
        for(LineItem item : lineItems) {
            total += item.getOrigPriceSubtotal();
        }
        return total;
    }
    
    /**
     * Gets the total discount for all items purchased.
     * @return total discount of all items purchased.
     */
    public final double getTotalDiscount() {
        double total = 0.0;
        for(LineItem item : lineItems) {
            total += item.getDiscountAmt();
        }
        return total;
    }

    /**
     * Creates a LineItem object from provided raw data. The LineItem does 
     * the job of find the product based on its id. The LineItem is then
     * added to an array of line items stored in this object.
     * 
     * @param prodId - the product id
     * @param qty - the quantity of product purchased
     */
    public final void addLineItem(final String prodId, final int qty) {
        // needs validation
        LineItem item = new LineItem(db, prodId, qty);
        addToArray(item);
    }
    
    private void addToArray(final LineItem item) {
        // needs validation
        LineItem[] tempItems = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
        tempItems[lineItems.length] = item;
        lineItems = tempItems;
    }
    
    /**
     * Gets a formatted receipt date. The format can be changed.
     * @return formatted receipt date
     */
    public String getReceiptDateFormatted() {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(receiptDate);
    }
    
    /**
     * Outputs any message to the designated output strategy. This is usually
     * used for error messages.
     * 
     * @param msg - the message to display.
     */
    public final void outputMessage(String msg) {
        output.outputMessage(msg);
    }
    
    /**
     * This method compiles a receipt from data accessible to this object. 
     * The format is rigidly fixed and should be made more flexible in 
     * the future. However, the output is flexible and the receipt will go
     * to the designated output strategy.
     * 
     * Also, note that there are some magic number violations that also
     * need to be fixed.
     */
    public final void outputReceipt() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        final String CRLF = "\n";
        final String CRLF2 = "\n\n";
        
        // Build header
        StringBuilder receiptData = new StringBuilder("Thank you for shopping at Kohls!\n\n");
        receiptData.append("Sold to: ").append(customer.getName()).append(CRLF);
        receiptData.append("Date of Sale: ").append(getReceiptDateFormatted()).append(CRLF);
        receiptData.append("Receipt No.: " ).append(Receipt2.receiptNo).append(CRLF2);
        output.outputReceipt(receiptData.toString());
        
        // Now process line items
        String[][] lineItemData = new String[lineItems.length+2][6];
        lineItemData[0][0] = "ID";
        lineItemData[0][1] = "Item";
        lineItemData[0][2] = "Price";
        lineItemData[0][3] = "Qty";
        lineItemData[0][4] = "Subtotal";
        lineItemData[0][5] = "Discount";
        
        lineItemData[1][0] = "--";
        lineItemData[1][1] = "----";
        lineItemData[1][2] = "-----";
        lineItemData[1][3] = "---";
        lineItemData[1][4] = "--------";
        lineItemData[1][5] = "--------";
         
        for(int row=2; row < (lineItems.length+2); row++) {
            int col = 0;
            lineItemData[row][col] = lineItems[row-2].getProduct().getProdId();
            lineItemData[row][++col] = lineItems[row-2].getProduct().getDescription();
            lineItemData[row][++col] = nf.format(lineItems[row-2].getProduct().getUnitPrice());
            lineItemData[row][++col] = ""+lineItems[row-2].getQty();
            lineItemData[row][++col] = nf.format(lineItems[row-2].getOrigPriceSubtotal());
            lineItemData[row][++col] = nf.format(lineItems[row-2].getDiscountAmt());
        }
        
        TableFormatter formatter = new TableFormatter();
        JustifyDirection[] justifyDir = {
            JustifyDirection.LEFT,JustifyDirection.LEFT,
            JustifyDirection.RIGHT,JustifyDirection.RIGHT,
            JustifyDirection.RIGHT,JustifyDirection.RIGHT
        };
        output.outputReceipt(formatter.toFormattedStr(lineItemData, justifyDir, receiptNo));
       
        // Now process totals
        receiptData = new StringBuilder();
        receiptData.append("\t\t\t\t\t\t--------").append(CRLF);
        double totalNet = getTotalBeforeDiscount();
        receiptData.append("\t\t\t\tNet Total: \t").append(nf.format(totalNet)).append(CRLF);
        double totalDiscount = getTotalDiscount();
        receiptData.append("\t\t\t\tTotal Saved: \t-").append(nf.format(totalDiscount)).append(CRLF);
        double totalDue = totalNet - totalDiscount;
        receiptData.append("\t\t\t\tTotal Due: \t").append(nf.format(totalDue)).append(CRLF);
        
        // Now generate data string...
        // Notice that the format is hardcoded into this method. We could do
        // better by using a format strategy in the future.
        output.outputReceipt(receiptData.toString());
    }

    ///////////// SPECIAL NOTE ABOUT PUBLIC GETTERS/SETTERS //////////////
    // We provide few public getters or setters in this class 
    // because we want to limit access to the associated properties. We want
    // those properties to only be available to this class. This is not
    // common, but is within the right of the programmer to control this.
    ///////////////////////////////////////////////////////////////////////
    
    /**
     * Sets and validates the data access strategy.
     * @param db - a data access strategy option. Send an error message
     * to the designated output strategy if not valid.
     */
    public void setDb(ReceiptDataAccessStrategy db) {
        if(db == null) {
            output.outputMessage(DATA_SRC_ERR);
        }
        this.db = db;
    }

    /**
     * Sets and validates the output strategy.
     * @param output - the designated output strategy option. 
     * @throws IllegalArgumentException if output is null or not a valid
     * option
     */
    public void setOutput(ReceiptOutputStrategy output) {
        if(output == null) {
            throw new IllegalArgumentException(OUTPUT_ERR);
        }
        this.output = output;
    }    
    
    /**
     * Sets the receipt date format using the format string options 
     * documented in the SimpleDateFormat class.
     * @param dateFormat - the date format string
     */
    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }
    

}
