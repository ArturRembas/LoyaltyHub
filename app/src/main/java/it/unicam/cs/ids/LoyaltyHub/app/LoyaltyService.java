package it.unicam.cs.ids.LoyaltyHub.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * The LoyaltyService class is responsible for implementing the business logic of the loyalty system,
 * providing methods for creating, updating, and querying customers, rewards, and redemption requests.
 * This class serves as the main service layer component for managing the loyalty program, encapsulating
 * the core business rules and data manipulation operations.
 * <p>
 * The LoyaltyService class interacts with the data access layer through various repository interfaces,
 * such as CustomerRepository, RewardRepository, and RedemptionRequestRepository, to perform CRUD operations
 * on the entities it manages. By delegating the actual data storage and retrieval tasks to the repositories,
 * the LoyaltyService maintains a clean separation of concerns between the business logic and data storage layers
 * of the application.
 * <p>
 * This design makes it easier to maintain and extend the application, as changes to the underlying data storage
 * mechanisms or the structure of the entities should not impact the way that the business logic is implemented.
 * The service layer can focus on implementing the business rules and coordinating the interactions between
 * different entities, while the data access layer takes care of persisting and retrieving the data.
 */
@Service
public class LoyaltyService implements ILoyaltyService{

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
        IStore store = storeRepository.findById(storeId).orElseThrow(() -> new IllegalArgumentException("Invalid store ID"));

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
     /*   if (!customerRepository.existsById(updatedCustomer.getId())) {
            throw new NoSuchElementException("Customer not found with ID: " + updatedCustomer.getId());
        }
        return customerRepository.save(updatedCustomer);
        */
    	return new Customer();
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

	@Override
	public void registerCustomer(ICustomer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignLoyaltyPoints(ICustomer customer, int points) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean redeemReward(ICustomer customer, Reward reward) {
		// TODO Auto-generated method stub
		return false;
	}
}
