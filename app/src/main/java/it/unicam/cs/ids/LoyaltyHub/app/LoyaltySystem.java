package it.unicam.cs.ids.LoyaltyHub.app;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * The LoyaltySystem class provides a high-level API for interacting with the core components of
 * the loyalty program, including customers, stores, rewards, and redemption requests. It serves as
 * the main entry point for clients of the loyalty program, exposing methods to add and update customers,
 * create rewards, and process redemption requests.
 * <p>
 * This class encapsulates the business logic and data manipulation operations of the loyalty program,
 * coordinating the interactions between the various entities and the underlying data storage layer.
 * By providing a unified interface to the loyalty program, the LoyaltySystem class makes it easier
 * for clients to interact with the program's functionality without having to be concerned about the
 * internal details of the implementation.
 * <p>
 * The LoyaltySystem class delegates the actual data storage and retrieval tasks to the LoyaltyService
 * class, which in turn interacts with the data access layer through various repository interfaces.
 * This design maintains a clean separation of concerns between the business logic and data storage layers
 * of the application, ensuring that changes to the underlying data storage mechanisms or the structure
 * of the entities do not impact the way that the business logic is implemented.
 * <p>
 * The LoyaltySystem class is designed to be easily extensible, allowing for the addition of new features
 * and functionality to the loyalty program without requiring significant changes to the existing codebase.
 * Clients of the loyalty program can simply interact with the LoyaltySystem API to access the desired
 * functionality, without needing to understand the details of the underlying implementation.
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
