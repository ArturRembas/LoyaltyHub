package it.unicam.cs.ids.LoyaltyHub.app;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CustomerStorePoints implements ICustomerStorePoints {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String customerId;
    private int storeId;
    private int loyaltyPoints;
	  
	

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

}
