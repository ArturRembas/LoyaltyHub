package it.unicam.cs.ids.LoyaltyHub.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
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
    private PointsPolicyRepository pointsPolicyRepository;
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
     * Registers a new point policy.
     *
     * @param pointsPolicy to add
     * @return the registered point policy object
     */
    public PointsPolicy addPointsPolicy(PointsPolicy pointsPolicy) {
        return pointsPolicyRepository.save(pointsPolicy);
    }
    
    
    /**
     * Registers a new store.
     *
     * @param store the store object to be registered
     * @return the registered store object
     */
    public Store addStore(Store store) {
        return storeRepository.save(store);
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
    
    public Customer updateCustomer(Customer updatedCustomer) {
        if (!customerRepository.existsById(updatedCustomer.getId())) {
            throw new NoSuchElementException("Customer not found with ID: " + updatedCustomer.getId());
        }
        return customerRepository.save(updatedCustomer);
    }


	public void sendNotification(Customer customer, Reward reward) {
		// TODO Auto-generated method stub
		
	}

	public void updateDatabase(Customer customer, Reward reward, Store store) {

		CustomerStorePointsKey key = new CustomerStorePointsKey(customer.getId(), store.getId());
        ICustomerStorePoints customerStorePoints = customerStorePointsRepository.findById(key)
                .orElseThrow(() -> new NoSuchElementException("CustomerStorePoints not found with key: " + key));

        int remainingPoints = customerStorePoints.getLoyaltyPoints() - reward.getPointsRequired();
        customerStorePoints.setLoyaltyPoints(remainingPoints);

        // Save updated customer points
        customerStorePointsRepository.save(customerStorePoints);

        // Save reward information
        reward.setCustomer(customer);
        reward.setStore(store);
        rewardRepository.save(reward);
		
	}
}
