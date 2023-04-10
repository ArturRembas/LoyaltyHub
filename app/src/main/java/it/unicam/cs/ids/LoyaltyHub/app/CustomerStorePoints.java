package it.unicam.cs.ids.LoyaltyHub.app;

import java.util.NoSuchElementException;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


/**
 * CustomerStorePoints class represents the association between a customer and a store,
 * along with the points earned by the customer at that store.
 * <p>
 * This class serves as a container to store the relationship between a specific customer
 * and a store, as well as the points the customer has earned through purchases at the
 * store. The CustomerStorePoints instances are managed by the Customer class, which holds
 * a map of CustomerStorePoints objects for each store the customer has points in.
 * <p>
 * The class also provides methods to add or remove points, as well as checking the
 * points balance for the associated customer and store.
 */
@Entity
public class CustomerStorePoints implements ICustomerStorePoints {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String customerId;
    private int storeId;
    private int loyaltyPoints;
    private CustomerStorePointsRepository customerStorePointsRepository;
	

	public CustomerStorePoints() {
    }
	
	public CustomerStorePoints(String customerId, int storeId, int loyaltyPoints) {
        this.customerId = customerId;
        this.storeId = storeId;
        this.loyaltyPoints = loyaltyPoints;
    }
	
	public CustomerStorePoints(CustomerStorePointsKey key, ICustomer customer, StoreInterface store, int i) {
		// TODO Auto-generated constructor stub
	}
	
	public ICustomerStorePoints getCustomerStorePoints(String customerId, int storeId) {
	    CustomerStorePointsKey key = new CustomerStorePointsKey(customerId, storeId);
		return customerStorePointsRepository.findById(key)
	        .orElseThrow(() -> new NoSuchElementException("CustomerStorePoints not found with key: " + key));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id=id;

	}

	public int getCustomerId() {
		return id;
	}

	public void setCustomerId(String customerId) {
		this.customerId=customerId;

	}

	public int getStoreId() {
		return storeId;
	}


	public void setStoreId(int storeId) {
		this.storeId=storeId;
	}


	public int getLoyaltyPoints() {
		return loyaltyPoints;
	}

	public void setLoyaltyPoints(int loyaltyPoints) {
		this.loyaltyPoints=loyaltyPoints;
	}

	public void addPoints(int points) {
        this.loyaltyPoints += points;
    }

    public boolean redeemPoints(int points) {
        if (this.loyaltyPoints >= points) {
            this.loyaltyPoints -= points;
            return true;
        } else {
            return false;
        }
    }

}
