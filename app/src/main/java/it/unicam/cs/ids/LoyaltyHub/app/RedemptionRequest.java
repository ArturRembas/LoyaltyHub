package it.unicam.cs.ids.LoyaltyHub.app;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * RedemptionRequest class represents a request made by a customer to redeem loyalty points for a reward.
 */
@Entity
public class RedemptionRequest implements IRedemptionRequest {
	

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
    @ManyToOne
    @JoinColumn(name = "reward_id")
    private Reward reward;
    private int pointsToRedeem;
    private LocalDateTime date;
    private boolean isApproved;
   
    

    public RedemptionRequest() {
    }

    
    
    public RedemptionRequest(int id, Customer customer, int pointsToRedeem, int rewardId, LocalDateTime date,
			boolean isApproved, Store store, Reward reward) {
		this.id = id;
		this.customer = customer;
		this.pointsToRedeem = pointsToRedeem;
		this.date = date;
		this.isApproved = isApproved;
		this.store = store;
		this.reward=reward;
	}

    
    // Getters and Setters

    @Override
	public int getId() {
        return id;
    }


    @Override
	public int getPointsToRedeem() {
        return pointsToRedeem;
    }

    @Override
	public LocalDateTime getDate() {
        return date;
    }

    @Override
	public boolean isApproved() {
        return isApproved;
    }

    // Setters

    @Override
	public void setId(int id) {
        this.id = id;
    }

    @Override
	public void setPointsToRedeem(int pointsToRedeem) {
        this.pointsToRedeem = pointsToRedeem;
    }

    @Override
	public void setApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    // Method to approve a redemption request
    @Override
	public void approve() {
        this.isApproved = true;
    }



	@Override
	public Customer getCustomer() {
		return customer;
	}



	@Override
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	@Override
	public Store getStore() {
		return store;
	}



	@Override
	public void setStore(Store store) {
		this.store = store;
	}



	@Override
	public void setDate(LocalDateTime date) {
		this.date = date;
	}


	@Override
	public Reward getReward() {
		return reward;
	}


	@Override
	public void setReward(Reward reward) {
		this.reward = reward;
	}

    
}