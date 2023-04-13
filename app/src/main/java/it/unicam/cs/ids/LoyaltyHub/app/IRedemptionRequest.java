package it.unicam.cs.ids.LoyaltyHub.app;

import java.time.LocalDateTime;

public interface IRedemptionRequest {

	int getId();

	int getPointsToRedeem();

	LocalDateTime getDate();

	boolean isApproved();

	void setId(int id);

	void setPointsToRedeem(int pointsToRedeem);

	void setApproved(boolean isApproved);

	// Method to approve a redemption request
	void approve();

	Customer getCustomer();

	void setCustomer(Customer customer);

	int getRewardId();

	void setRewardId(int rewardId);

	Store getStore();

	void setStore(Store store);

	void setDate(LocalDateTime date);

}