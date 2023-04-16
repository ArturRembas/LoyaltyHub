package it.unicam.cs.ids.LoyaltyHub.app;

import java.util.List;

/**
 * ICustomer interface represents a contract for a customer in the loyalty system.
 * <p>
 * This interface defines the common operations that can be performed by a customer,
 * such as adding points, redeeming points, and viewing their points balance for a
 * specific store. Implementing classes must provide their own implementation for these
 * methods, ensuring that the loyalty system remains flexible and adaptable to different
 * customer behavior patterns.
 * <p>
 * By utilizing the ICustomer interface, the loyalty system can be easily extended and
 * modified to accommodate new customer types and requirements, while still preserving
 * a consistent and well-defined API for interacting with customers.
 */
public interface ICustomer {
	String getId();
	void setId(String id);
    String getEmail();
    void setEmail(String email);
    String getAddress();
    void setAddress(String address);
    String getName();
    void setName(String name);
    String getSurname();
    void setSurname(String surname);
    String getPassword();
    void setPassword(String password);
    String getPhoneNumber();
    void setPhoneNumber(String phoneNumber);
	List<RedemptionRequest> getRedemptionRequests();
	void setRedemptionRequests(List<RedemptionRequest> redemptionRequests);
}
