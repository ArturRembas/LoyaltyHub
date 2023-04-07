package it.unicam.cs.ids.LoyaltyHub.app;

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
}
