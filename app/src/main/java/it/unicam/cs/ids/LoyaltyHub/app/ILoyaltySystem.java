package it.unicam.cs.ids.LoyaltyHub.app;

public interface ILoyaltySystem {
	void registerCustomer(ICustomer customer);
    void assignLoyaltyPoints(ICustomer customer, int points);
    boolean redeemReward(ICustomer customer, Reward reward);
}
