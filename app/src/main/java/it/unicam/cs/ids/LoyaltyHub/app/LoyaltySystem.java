package it.unicam.cs.ids.LoyaltyHub.app;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * LoyaltySystem class represents the main loyalty system that manages customer registration, database updates,
 * and sending notifications for rewards.
 */

public class LoyaltySystem {
	@Autowired
	private LoyaltyService loyaltyService;
	
	@Autowired
    private CustomerRepository customerRepository;
	
	public LoyaltySystem(LoyaltyService loyaltyService) {
        this.loyaltyService = loyaltyService;
    }
	
    /**
     * Registers a new customer in the loyalty system.
     *
     * @param customer The Customer object to register.
     */
    public void registerCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    /**
     * Updates the database after a customer redeems a reward.
     *
     * @param customer The customer who redeemed the reward.
     * @param reward   The reward that was redeemed.
     * @param store    The store where the reward was redeemed.
     */
    public void updateDatabase(Customer customer, Reward reward, Store store) {
        loyaltyService.updateDatabase(customer, reward, store);
    }

    /**
     * Sends a notification to the customer about the redeemed reward.
     *
     * @param customer The Customer who redeemed the reward.
     * @param reward   The Reward that was redeemed by the customer.
     */
    /**
     * Sends a notification to a customer about a redeemed reward.
     *
     * @param customer The customer who redeemed the reward.
     * @param reward   The reward that was redeemed.
     */
    public void sendNotification(Customer customer, Reward reward) {
        loyaltyService.sendNotification(customer, reward);
    }

}
