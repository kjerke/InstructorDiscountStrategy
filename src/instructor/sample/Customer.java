package instructor.sample;

/**
 * This class represents a real customer in a
 * retail sales environment. It's job is to
 * manage information about a customer.
 * 
 * @author Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class Customer {
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
    public final String getCustId() {
        return custId;
    }

    /**
     * Sets the customer id value
     * @param custId - a alphanumeric value
     * @throws IllegalArgumentException if custId is null or length == 0
     */
    public final void setCustId(final String custId) {
        if(custId == null || custId.length() == 0) {
            throw new IllegalArgumentException(PARAM_ERR);
        }
        this.custId = custId;
    }

    public final String getName() {
        return name;
    }

    public final void setName(final String name) {
         if(name == null || name.length() == 0) {
            throw new IllegalArgumentException(PARAM_ERR);
        }
        this.name = name;
    }

    public final String getAddress() {
        return address;
    }

    public final void setAddress(final String address) {
        if(address == null || address.length() == 0) {
            throw new IllegalArgumentException(PARAM_ERR);
        }
        this.address = address;
    }

    public final String getCity() {
        return city;
    }

    public final void setCity(final String city) {
        if(city == null || city.length() == 0) {
            throw new IllegalArgumentException(PARAM_ERR);
        }
        this.city = city;
    }

    public final String getState() {
        return state;
    }

    public final void setState(final String state) {
        if(state == null || state.length() == 0) {
            throw new IllegalArgumentException(PARAM_ERR);
        }
        this.state = state;
    }

    public final String getZip() {
        return zip;
    }

    public final void setZip(final String zip) {
        if(zip == null || zip.length() == 0) {
            throw new IllegalArgumentException(PARAM_ERR);
        }
        this.zip = zip;
    }
    
    
}
