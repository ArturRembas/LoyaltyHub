package it.unicam.cs.ids.LoyaltyHub.app;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 * CustomerStorePointsKey is the composite primary key for the CustomerStorePoints entity.
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
