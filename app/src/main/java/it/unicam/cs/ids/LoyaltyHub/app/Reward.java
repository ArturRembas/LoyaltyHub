package it.unicam.cs.ids.LoyaltyHub.app;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Reward class represents a reward that can be redeemed by a customer using their loyalty points.
 */
@Entity
public class Reward {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Customer customer;
    private Store store;
    private String name;
    private int pointsRequired;

    public Reward() {
    }

    public Reward(String name, int pointsRequired) {
        this.name = name;
        this.pointsRequired = pointsRequired;
    }
    
    // Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPointsRequired() {
		return pointsRequired;
	}

	public void setPointsRequired(int pointsRequired) {
		this.pointsRequired = pointsRequired;
	}

	public void setStore(Store store) {
		this.store=store;		
	}
	
	public Store getStore() {
		return store;
	}

	public void setCustomer(Customer customer) {
		this.customer=customer;
	}
	
	public Customer getCustomer() {
		return customer;
	}
    
}