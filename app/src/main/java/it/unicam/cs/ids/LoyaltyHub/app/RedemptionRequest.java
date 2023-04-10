package it.unicam.cs.ids.LoyaltyHub.app;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * RedemptionRequest class represents a request made by a customer to redeem loyalty points for a reward.
 */
@Entity
public class RedemptionRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int customerId;
    private int pointsToRedeem;
    private int rewardId;
    private String date;
    private boolean isApproved;

    public RedemptionRequest() {
    }

    public RedemptionRequest(int id, int customerId, int rewardId, int pointsToRedeem, String date) {
        this.id=id;
    	this.customerId = customerId;
    	this.pointsToRedeem = pointsToRedeem;
    	this.date = date;
        this.rewardId = rewardId;
        this.isApproved = false;
    }
    
    // Getters and Setters

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getPointsToRedeem() {
        return pointsToRedeem;
    }

    public String getDate() {
        return date;
    }

    public boolean isApproved() {
        return isApproved;
    }

    // Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setPointsToRedeem(int pointsToRedeem) {
        this.pointsToRedeem = pointsToRedeem;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    // Method to approve a redemption request
    public void approve() {
        this.isApproved = true;
    }

    
}