package it.unicam.cs.ids.LoyaltyHub.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * LoyaltyService class provides the core business logic for the loyalty system.
 */
@Service
public class LoyaltyService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private CustomerStorePointsRepository customerStorePointsRepository;
    @Autowired
    private RewardRepository rewardRepository;

    /**
     * Registers a new customer.
     *
     * @param customer the customer object to be registered
     * @return the registered customer object
     */
    public Customer registerCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    /**
     * Assigns loyalty points to a customer for a specific store.
     *
     * @param customerId      the ID of the customer
     * @param storeId         the ID of the store
     * @param purchaseAmount  the purchase amount for calculating points
     * @return the updated CustomerStorePoints object
     */
    public CustomerStorePoints assignLoyaltyPoints(String customerId, int storeId, double purchaseAmount) {
        ICustomer customer = customerRepository.findById(customerId).orElseThrow(() -> new IllegalArgumentException("Invalid customer ID"));
        StoreInterface store = storeRepository.findById(storeId).orElseThrow(() -> new IllegalArgumentException("Invalid store ID"));

        CustomerStorePointsKey key = new CustomerStorePointsKey(customerId, storeId);
        ICustomerStorePoints customerStorePoints = customerStorePointsRepository.findById(key).orElse(new CustomerStorePoints(key, customer, store, 0));

        int points = store.getPointsPolicy().calculatePoints(purchaseAmount);
        customerStorePoints.setLoyaltyPoints(customerStorePoints.getLoyaltyPoints() + points);

        return customerStorePointsRepository.save(customerStorePoints);
    }

    /**
     * Redeems a reward for a customer in a specific store.
     *
     * @param customerId the ID of the customer
     * @param storeId    the ID of the store
     * @param rewardId   the ID of the reward to be redeemed
     * @return the updated CustomerStorePoints object
     */
    public CustomerStorePoints redeemReward(String customerId, int storeId, int rewardId) {
        CustomerStorePointsKey key = new CustomerStorePointsKey(customerId, storeId);
        ICustomerStorePoints customerStorePoints = customerStorePointsRepository.findById(key).orElseThrow(() -> new IllegalArgumentException("Invalid customer ID or store ID"));

        Reward reward = rewardRepository.findById(rewardId).orElseThrow(() -> new IllegalArgumentException("Invalid reward ID"));

        if (customerStorePoints.getLoyaltyPoints() < reward.getPointsRequired()) {
            throw new IllegalArgumentException("Not enough points to redeem the reward");
        }

        customerStorePoints.setLoyaltyPoints(customerStorePoints.getLoyaltyPoints() - reward.getPointsRequired());

        return customerStorePointsRepository.save(customerStorePoints);
    }

    /**
     * Retrieves the loyalty points for a specific customer in a specific store.
     *
     * @param customerId the ID of the customer
     * @param storeId    the ID of the store
     * @return the CustomerStorePoints object
     */
    public ICustomerStorePoints getCustomerStorePoints(String customerId, int storeId) {
        CustomerStorePointsKey key = new CustomerStorePointsKey(customerId, storeId);
        return customerStorePointsRepository.findById(key).orElseThrow(() -> new IllegalArgumentException("Invalid customer ID or store ID"));
    }

	public void updateDatabase(Customer customer, Reward reward, Store store) {
		// TODO Auto-generated method stub
		
	}

	public void sendNotification(Customer customer, Reward reward) {
		// TODO Auto-generated method stub
		
	}
}
