package instructor.sample;

/**
 * This is an example of playing it safe. Using an interface to represent
 * customer implementations is probably not necessary, but it does allow
 * varying behaviors in the future should they be needed. NOTE: while these
 * methods are documented in the implementation classes, they should also
 * be documented here in the future.
 * 
 * @author Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public interface ICustomer {

    public abstract String getAddress();

    public abstract String getCity();

    public abstract String getCustId();

    public abstract String getName();

    public abstract String getState();

    public abstract String getZip();

    public abstract void setAddress(final String address);

    public abstract void setCity(final String city);

    public abstract void setCustId(final String custId);

    public abstract void setName(final String name);

    public abstract void setState(final String state);

    public abstract void setZip(final String zip);
    
}
