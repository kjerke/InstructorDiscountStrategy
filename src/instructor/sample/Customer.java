package instructor.sample;

/**
 * This class represents a real customer in a
 * retail sales environment. It's job is to
 * manage information about a customer. Note that while it acts as a strategy
 * object, due to the interface inheritance, this is probably not needed 
 * because it's unlikely that there will be more than one implementation. 
 * Still, it makes it more flexible by doing so.
 * 
 * @author Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class Customer implements ICustomer {
    private String custId;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private final String PARAM_ERR = "Field cannot be null or zero length";

    /** 
     * Custom constructor. Delegates validate of parameters to setters
     * @param custId - the customer id
     * @param name - the customer full name
     */
    public Customer(String custId, String name) {
        setCustId(custId);
        setName(name);
    }

    /**
     * Gets the cutomer id
     * @return the cutomer id
     */
    @Override
    public final String getCustId() {
        return custId;
    }

    /**
     * Sets the customer id value
     * @param custId - a alphanumeric value
     * @throws IllegalArgumentException if custId is null or length == 0
     */
    @Override
    public final void setCustId(final String custId) {
        if(custId == null || custId.length() == 0) {
            throw new IllegalArgumentException(PARAM_ERR);
        }
        this.custId = custId;
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final void setName(final String name) {
         if(name == null || name.length() == 0) {
            throw new IllegalArgumentException(PARAM_ERR);
        }
        this.name = name;
    }

    @Override
    public final String getAddress() {
        return address;
    }

    @Override
    public final void setAddress(final String address) {
        if(address == null || address.length() == 0) {
            throw new IllegalArgumentException(PARAM_ERR);
        }
        this.address = address;
    }

    @Override
    public final String getCity() {
        return city;
    }

    @Override
    public final void setCity(final String city) {
        if(city == null || city.length() == 0) {
            throw new IllegalArgumentException(PARAM_ERR);
        }
        this.city = city;
    }

    @Override
    public final String getState() {
        return state;
    }

    @Override
    public final void setState(final String state) {
        if(state == null || state.length() == 0) {
            throw new IllegalArgumentException(PARAM_ERR);
        }
        this.state = state;
    }

    @Override
    public final String getZip() {
        return zip;
    }

    @Override
    public final void setZip(final String zip) {
        if(zip == null || zip.length() == 0) {
            throw new IllegalArgumentException(PARAM_ERR);
        }
        this.zip = zip;
    }
    
    
}
