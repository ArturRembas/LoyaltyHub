package it.unicam.cs.ids.LoyaltyHub.app;

import java.time.LocalDateTime;

/**
* IPurchase interface represents a purchase made by a customer at a store.
* It contains information about the customer, the store, the purchase amount,
* and the points earned by the customer for a purchase.
*/
public interface IPurchase {

	// Getters and Setters
	int getId();

	void setId(int id);

	double getTotalAmount();

	void setTotalAmount(double amount);

	int getPointsEarned();

	void setPointsEarned(int pointsEarned);

	LocalDateTime getDate();

	void setDate(LocalDateTime date);

	Customer getCustomer();

	void setCustomer(Customer customer);

	Store getStore();

	void setStore(Store store);

	double getAmount();

	void setAmount(double amount);

}