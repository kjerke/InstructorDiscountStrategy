package instructor.sample;

/**
 *
 * @author Instlogin
 */
public class Customer {
    private String custId;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;

    public Customer(String custId, String name) {
        setCustId(custId);
        setName(name);
    }

    public final String getCustId() {
        return custId;
    }

    public final void setCustId(final String custId) {
        // validation is needed
        this.custId = custId;
    }

    public final String getName() {
        return name;
    }

    public final void setName(final String name) {
        // validation is needed
        this.name = name;
    }

    public final String getAddress() {
        return address;
    }

    public final void setAddress(final String address) {
        // validation is needed
        this.address = address;
    }

    public final String getCity() {
        return city;
    }

    public final void setCity(final String city) {
        // validation is needed
        this.city = city;
    }

    public final String getState() {
        return state;
    }

    public final void setState(final String state) {
        // validation is needed
        this.state = state;
    }

    public final String getZip() {
        return zip;
    }

    public final void setZip(final String zip) {
        // validation is needed
        this.zip = zip;
    }
    
    
}
