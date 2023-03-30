package it.unicam.cs.ids.LoyaltyHub.app;

public interface ICustomer {
	String getCustomerId();
    int getLoyaltyPoints();
    void setLoyaltyPoints(int loyaltyPoints);
    String getEmail();
}
