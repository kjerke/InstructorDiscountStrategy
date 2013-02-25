package instructor.sample;

/**
 *
 * @author Instlogin
 */
public class LineItem {
    ReceiptDataAccessStrategy db; // strategy component (DIP compliant)
    private Product product;
    private int qty;

    public LineItem(ReceiptDataAccessStrategy db, String prodId, int qty) {
        this.db = db;
        this.product = findProduct(prodId);
        setQty(qty);
    }
    
    private final Product findProduct(final String prodId) {
        // validation needed
        return db.findProduct(prodId);
    }
    
    public final double getOrigPriceSubtotal() {
        return product.getUnitPrice() * qty;
    }
    
    public final double getDiscountAmt() {
        return product.getDiscountStrategy().getDiscountAmt(product.getUnitPrice(), qty);
    }

    public final Product getProduct() {
        return product;
    }

    public final void setProduct(final Product product) {
        // validation needed
        this.product = product;
    }

    public final int getQty() {
        return qty;
    }

    public final void setQty(final int qty) {
        // validation needed
        this.qty = qty;
    }
    
    
}
