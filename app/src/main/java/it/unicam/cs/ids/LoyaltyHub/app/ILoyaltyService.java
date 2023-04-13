package it.unicam.cs.ids.LoyaltyHub.app;


/**
 * ILoyaltySystem interface represents a contract for managing the functionality of the loyalty system.
 * <p>
 * This interface defines the common operations required for managing customers, stores, rewards, and
 * other entities in the loyalty system. Implementing classes must provide their own implementation
 * for these methods, ensuring that the loyalty system can handle different data storage and
 * retrieval mechanisms, as well as different business rules.
 * <p>
 * By utilizing the ILoyaltySystem interface, the application can be easily extended and modified to
 * accommodate new features and requirements while still preserving a consistent and well-defined API
 * for managing the loyalty program. This ensures that the application remains flexible and maintainable
 * as the needs of the loyalty program evolve over time.
 */
public interface ILoyaltyService {
	void registerCustomer(ICustomer customer);
    void assignLoyaltyPoints(ICustomer customer, int points);
    boolean redeemReward(ICustomer customer, IReward reward);
    
}
