package it.unicam.cs.ids.LoyaltyHub.app;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * Store class represents a store that uses the loyalty program. Each store has a unique ID, a name,
 * an address, and a points policy associated with it. The points policy defines how customers earn
 * and redeem points at the store.
 *
 * @author YourName
 */
@Entity
public class Store implements IStore {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String address;
    @ManyToOne
    @JoinColumn(name = "points_policy_id")
    private PointsPolicy pointsPolicy;

    /**
     * Default constructor for the Store class.
     */
    public Store() {
    	this.pointsPolicy = new PointsPolicy();
    }
    
    /**
     * Constructs a Store instance with the specified name and address.
     *
     * @param name    The name of the store.
     * @param address The address of the store.
     */
    public Store(String name, String address) {
        this.name = name;
        this.address = address;
    }

    /**
     * Gets the ID of this store.
     *
     * @return The ID of this store.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of this store.
     *
     * @param id The ID to set for this store.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name of this store.
     *
     * @return The name of this store.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of this store.
     *
     * @param name The name to set for this store.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the address of this store.
     *
     * @return The address of this store.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of this store.
     *
     * @param address The address to set for this store.
     */
    public void setAddress(String address) {
        this.address = address;
    }

	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	
	public void removeCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	
	public PointsPolicy getPointsPolicy() {
		return pointsPolicy;
	}

	public void setPointsPolicy(PointsPolicy pointsPolicy) {
		this.pointsPolicy=pointsPolicy;	
	}
}
