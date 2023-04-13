package it.unicam.cs.ids.LoyaltyHub.app;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

/**
 * Reward class represents a reward that can be redeemed by a customer using their loyalty points.
 */
@Entity
public class Reward implements IReward{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "store_id")
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

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int getPointsRequired() {
		return pointsRequired;
	}

	@Override
	public void setPointsRequired(int pointsRequired) {
		this.pointsRequired = pointsRequired;
	}

	@Override
	public void setStore(Store store) {
		this.store=store;		
	}
	
	@Override
	public Store getStore() {
		return store;
	}

	@Override
	public void setCustomer(Customer customer) {
		this.customer=customer;
	}
	
	@Override
	public Customer getCustomer() {
		return customer;
	}
    
}