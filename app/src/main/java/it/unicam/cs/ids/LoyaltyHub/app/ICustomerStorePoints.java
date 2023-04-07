package it.unicam.cs.ids.LoyaltyHub.app;

public interface ICustomerStorePoints {

    int getId();

    void setId(int id);

    int getCustomerId();

    void setCustomerId(String customerId);

    int getStoreId();

    void setStoreId(int storeId);

    int getLoyaltyPoints();

    void setLoyaltyPoints(int loyaltyPoints);
}
