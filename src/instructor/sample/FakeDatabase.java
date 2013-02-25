package instructor.sample;

public class FakeDatabase implements ReceiptDataAccessStrategy {
    private Customer[] customers = {
        new Customer("100", "John Smith"),
        new Customer("200", "Sally Jones"),
        new Customer("300", "Bob Clementi")
    };
    
    private Product[] products = {
        new Product("A101", "MLB Brewer's Hat ", 19.95, new PercentOffDiscount(0.15)),
        new Product("B205", "Men's Dress Shirt", 35.50, new QtyDiscount(.10,5)),
        new Product("C222", "Women's Socks    ", 9.50, new NoDiscount())
    };
    
    @Override
    public final Customer findCustomer(final String custId) {
        // validation is needed
        Customer customer = null;
        for(Customer c : customers) {
            if(custId.equals(c.getCustId())) {
                customer = c;
                break;
            }
        }
        
        return customer;
    }
    
    @Override
    public final Product findProduct(final String prodId) {
        // validation is needed
        Product product = null;
        for(Product p : products) {
            if(prodId.equals(p.getProdId())) {
                product = p;
                break;
            }
        }
        
        return product;
    }
}
