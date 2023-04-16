package it.unicam.cs.ids.LoyaltyHub.app;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
* Purchase class represents a purchase made by a customer at a store.
* It contains information about the customer, the store, the purchase amount,
* and the points earned by the customer for this purchase.
*/
@Entity
public class Purchase implements IPurchase {

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
    @JoinColumn(name = "customer_store_points_id")
    private CustomerStorePoints customerStorePoints;
    private double amount;
    private int pointsEarned;
    private LocalDateTime date;

    public Purchase() {
    }

    public Purchase(Customer customer, Store store, double amount, int pointsEarned, LocalDateTime date) {
        this.customer = customer;
        this.store = store;
        this.amount = amount;
        this.pointsEarned = pointsEarned;
        this.date = date;
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
	public double getTotalAmount() {
		return amount;
	}

	@Override
	public void setTotalAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public int getPointsEarned() {
		return pointsEarned;
	}

	@Override
	public void setPointsEarned(int pointsEarned) {
		this.pointsEarned = pointsEarned;
	}

	@Override
	public LocalDateTime getDate() {
		return date;
	}

	@Override
	public void setDate(LocalDateTime date) {
		this.date = date;
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
	public double getAmount() {
		return amount;
	}

	@Override
	public void setAmount(double amount) {
		this.amount = amount;
	}

	public CustomerStorePoints getCustomerStorePoints() {
		return customerStorePoints;
	}

	public void setCustomerStorePoints(CustomerStorePoints customerStorePoints) {
		this.customerStorePoints = customerStorePoints;
	}

}
