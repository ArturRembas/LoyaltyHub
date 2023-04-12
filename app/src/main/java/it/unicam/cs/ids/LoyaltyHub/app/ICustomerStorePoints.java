package it.unicam.cs.ids.LoyaltyHub.app;


/**
 * ICustomerStorePoints interface represents a contract for managing the relationship
 * between a customer and a store in the loyalty system.
 * <p>
 * This interface defines the common operations for managing the points balance and
 * interaction between a customer and a store. Implementing classes must provide their
 * own implementation for these methods, ensuring that the loyalty system can handle
 * different strategies for points accumulation and redemption.
 * <p>
 * By using the ICustomerStorePoints interface, the loyalty system can be easily
 * extended and modified to accommodate new store-customer relationship types and
 * requirements while still preserving a consistent and well-defined API for managing
 * the points balances and interactions between customers and stores.
 */
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
