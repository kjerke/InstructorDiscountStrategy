package instructor.sample;

/**
 * This class represents a simulation of a product in a retail sales
 * organization.
 * 
 * NOTE: JavaDoc documentation is incomplete. Need to fix!!!
 * 
 * @author  Jim Lombardo
 * @version 1.00
 */
public class Product {
    private String prodId;
    private String description;
    private double unitPrice;
    // strategy component (DIP compliant)
    private DiscountStrategy discountStrategy;

    public Product(String prodId, String description, double unitPrice, DiscountStrategy discountStrategy) {
        setProdId(prodId);
        setDescription(description);
        setUnitPrice(unitPrice);
        setDiscountStrategy(discountStrategy);
    }

    public final String getProdId() {
        return prodId;
    }

    public final void setProdId(final String prodId) {
        // needs validation
        this.prodId = prodId;
    }

    public final String getDescription() {
        return description;
    }

    public final void setDescription(final String description) {
        // needs validation
        this.description = description;
    }

    public final double getUnitPrice() {
        return unitPrice;
    }

    public final void setUnitPrice(final double unitPrice) {
        // needs validation
        this.unitPrice = unitPrice;
    }

    public final DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    public final void setDiscountStrategy(final DiscountStrategy discountStrategy) {
        // needs validation
        this.discountStrategy = discountStrategy;
    }
    
    
}
