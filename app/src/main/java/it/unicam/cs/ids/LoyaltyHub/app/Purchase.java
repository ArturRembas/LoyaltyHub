package it.unicam.cs.ids.LoyaltyHub.app;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Purchase class represents a purchase made by a customer.
 */
@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int customerId;
    private double totalAmount;

    public Purchase() {
    }

    public Purchase(int customerId, double totalAmount) {
        this.customerId = customerId;
        this.totalAmount = totalAmount;
    }

    // Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

}

/*
package it.unicam.cs.ids.LoyaltyHub.app;

public class Purchase {

	private String id;
    private String customerId;
    private double totalAmount;
    private String date;

    public Purchase(String id, String customerId, double totalAmount, String date) {
        this.id = id;
        this.customerId = customerId;
        this.totalAmount = totalAmount;
        this.date = date;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getDate() {
        return date;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // Metodo per calcolare il numero di punti fedeltà basato sull'importo totale della spesa
    public int calculateLoyaltyPoints() {
        // Ad esempio, ogni 10 euro di spesa corrispondono a 1 punto fedeltà
        return (int) (totalAmount / 10);
    }

}
*/