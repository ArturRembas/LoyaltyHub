package it.unicam.cs.ids.LoyaltyHub.app;

import java.util.List;

/**
*IPointsPolicy represents an interface for managing points policies
*in the loyalty system. A points policy defines how points are earned and
*redeemed by customers.
*/
public interface IPointsPolicy {

    /**
     * Calculates the points earned for a given purchase amount.
     *
     * @param purchaseAmount The purchase amount.
     * @return The number of points earned.
     */
    int calculatePoints(double purchaseAmount);
    double getMinimumPurchaseAmount();
    void setMinimumPurchaseAmount(double minimumPurchaseAmount);
    double getPointsPerCurrency();
    void setPointsPerCurrency(double pointsPerCurrency);
	List<Reward> getRewards();
	void setRewards(List<Reward> rewards);
}
