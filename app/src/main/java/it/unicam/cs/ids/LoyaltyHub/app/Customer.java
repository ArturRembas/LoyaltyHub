package it.unicam.cs.ids.LoyaltyHub.app;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * Customer class represents a customer in the loyalty system.
 * Each customer has a unique ID, a name, an email, and a map
 * that associates a store with the corresponding points the customer has
 * earned from purchases at that store.
 * <p>
 * The customer can earn points by making purchases at stores that are part of
 * the loyalty system. The points are specific to each store and can be redeemed
 * for rewards at the respective store.
 * <p>
 * A customer can also request to redeem points at a store for a specific reward.
 * The redemption request will be processed by the store, and the points will be
 * deducted from the customer's account if the redemption is successful.
 */
@Entity
public class Customer implements ICustomer{

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String name;
    private String surname;
    private String address;
    private String phoneNumber;
    private String email;
    private String password;


    public Customer() {
    }

    public Customer(String email) {
        this.email = email;
    }
    
    public Customer(String email, String name, String surname, String address, String phoneNumber) {
    	this.email = email;
        this.name=name;
        this.surname=surname;
        this.address=address;
        this.phoneNumber=phoneNumber;
    }

    // Getters and Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    
}