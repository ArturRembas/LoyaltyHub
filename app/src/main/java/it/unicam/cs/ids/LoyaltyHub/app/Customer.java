package it.unicam.cs.ids.LoyaltyHub.app;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Customer class represents a customer in the loyalty program.
 */
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String email;
    private int loyaltyPoints;

    public Customer() {
    }

    public Customer(String email) {
        this.email = email;
        this.loyaltyPoints = 0;
    }

    // Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getLoyaltyPoints() {
		return loyaltyPoints;
	}

	public void setLoyaltyPoints(int loyaltyPoints) {
		this.loyaltyPoints = loyaltyPoints;
	}

    
}



/*
package it.unicam.cs.ids.LoyaltyHub.app;


public class Customer implements ICustomer{
	private String customerId;
	private String name;
	private String email;
    private int loyaltyPoints;

    public Customer(String customerId, String name, String email, int initialPoints) {
        this.customerId = customerId;
        this.name = name;
    	this.email = email;
        this.loyaltyPoints = initialPoints;
    }

    public String getCustomerId () {
    	return customerId;
    }
    
    //public void setCustomerId 
    
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }
    
    public String getEmail () {
    	return this.email;
    }
}
*/
