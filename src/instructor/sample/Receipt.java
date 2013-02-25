package instructor.sample;

import java.text.NumberFormat;
import java.util.Date;

/**
 *
 * @author Instlogin
 */
public class Receipt {
    private ReceiptDataAccessStrategy db; // strategy component (DIP compliant)
    private static int receiptNo = 0; // global counter
    private Customer customer;
    private LineItem[] lineItems;
    // strategy component (DIP compliant)
    private ReceiptOutputStrategy output;

    public Receipt(String custId, ReceiptDataAccessStrategy db, ReceiptOutputStrategy output) {
        this.db = db;
        this.output = output;
        this.customer = findCustomer(custId);
        receiptNo++;
        lineItems = new LineItem[0];
    }
    
    private final Customer findCustomer(final String custId) {
        // needs validation
        return db.findCustomer(custId);
    }    
    
    public final double getTotalBeforeDiscount() {
        double total = 0.0;
        for(LineItem item : lineItems) {
            total += item.getOrigPriceSubtotal();
        }
        return total;
    }
    
    public final double getTotalDiscount() {
        double total = 0.0;
        for(LineItem item : lineItems) {
            total += item.getDiscountAmt();
        }
        return total;
    }

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
    
    public final void outputReceipt() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        final String CRLF = "\n";
        final String CRLF2 = "\n\n";
        
        // Build header
        StringBuilder receiptData = new StringBuilder("Thank you for shopping at Kohls!\n\n");
        receiptData.append("Sold to: ").append(customer.getName()).append(CRLF);
        receiptData.append("Date of Sale: ").append(new Date()).append(CRLF);
        receiptData.append("Receipt No.: " ).append(Receipt.receiptNo).append(CRLF2);
        
        // Now process line items
        receiptData.append("ID\tItem\t\t\tPrice\tQty\tSubtotal\tDiscount").append(CRLF);
        receiptData.append("------------------------------------------------------------------------").append(CRLF);
        for(LineItem item : lineItems) {
            receiptData.append(item.getProduct().getProdId()).append("\t");
            receiptData.append(item.getProduct().getDescription()).append("\t");
            receiptData.append(nf.format(item.getProduct().getUnitPrice())).append("\t");
            receiptData.append(item.getQty()).append("\t");
            receiptData.append(nf.format(item.getOrigPriceSubtotal())).append("\t\t");
            receiptData.append(nf.format(item.getDiscountAmt())).append(CRLF);
        }
        
        // Now process totals
        receiptData.append(CRLF);
        receiptData.append("\t\t\t\t\t\t\t\t--------").append(CRLF);
        double totalNet = getTotalBeforeDiscount();
        receiptData.append("\t\t\t\t\t\tNet Total: \t").append(nf.format(totalNet)).append(CRLF);
        double totalDiscount = getTotalDiscount();
        receiptData.append("\t\t\t\t\t\tTotal Saved: \t-").append(nf.format(totalDiscount)).append(CRLF);
        double totalDue = totalNet - totalDiscount;
        receiptData.append("\t\t\t\t\t\tTotal Due: \t").append(nf.format(totalDue)).append(CRLF);
        
        // Now generate data string...
        // Notice that the format is hardcoded into this method. We could do
        // better by using a format strategy in the future.
        output.outputReceipt(receiptData.toString());
    }
    

}
