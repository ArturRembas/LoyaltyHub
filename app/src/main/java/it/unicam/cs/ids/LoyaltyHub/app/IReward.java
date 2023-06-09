package it.unicam.cs.ids.LoyaltyHub.app;

import java.util.List;

/**
 * IReward interface represents a contract for managing the functionality of rewards in the loyalty system.
 * <p>
 * This interface defines the common operations required for managing rewards, such as creating and
 * updating reward information, redeeming rewards, and querying available rewards for a particular
 * customer or store. Implementing classes must provide their own implementation for these methods,
 * ensuring that the loyalty system can handle different data storage and retrieval mechanisms, as well
 * as different reward types and redemption rules.
 * <p>
 * By utilizing the IReward interface, the application can be easily extended and modified to
 * accommodate new reward types and requirements while still preserving a consistent and well-defined API
 * for managing rewards in the loyalty program. This ensures that the application remains flexible and
 * maintainable as the needs of the reward system evolve over time.
 */
public interface IReward {

	int getId();

	void setId(int id);

	String getName();

	void setName(String name);

	int getPointsRequired();

	void setPointsRequired(int pointsRequired);

	void setStore(Store store);

	Store getStore();

	void setCustomer(Customer customer);

	Customer getCustomer();

	PointsPolicy getPointsPolicy();
	
	void setPointsPolicy(PointsPolicy pointsPolicy);
	
	List<RedemptionRequest> getRedemptionRequests();
	
	void setRedemptionRequests(List<RedemptionRequest> redemptionRequests);
}