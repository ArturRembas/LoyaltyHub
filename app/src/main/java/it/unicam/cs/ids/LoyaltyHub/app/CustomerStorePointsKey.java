package it.unicam.cs.ids.LoyaltyHub.app;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 * CustomerStorePointsKey class represents a composite key for the association between
 * a customer and a store in the CustomerStorePoints class.
 * <p>
 * This class is used to create a unique identifier for each CustomerStorePoints instance,
 * combining the customer ID and the store ID. As a result, it enables the proper mapping
 * and management of CustomerStorePoints instances in the system.
 * <p>
 * The class implements the Serializable interface to support the persistence and
 * retrieval of CustomerStorePoints objects using the JPA framework.
 */
@Embeddable
public class CustomerStorePointsKey implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "customer_id")
    private String customerId;

    @Column(name = "store_id")
    private int storeId;

    /**
     * Default constructor.
     */
    public CustomerStorePointsKey() {
    }

    /**
     * Constructs a new CustomerStorePointsKey with the given customer and store IDs.
     *
     * @param customerId2 the ID of the customer
     * @param storeId    the ID of the store
     */
    public CustomerStorePointsKey(String customerId2, int storeId) {
        this.customerId = customerId2;
        this.storeId = storeId;
    }

    // Getters and Setters

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    // hashCode and equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerStorePointsKey that = (CustomerStorePointsKey) o;
        return customerId == that.customerId && storeId == that.storeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, storeId);
    }
}
