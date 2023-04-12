package it.unicam.cs.ids.LoyaltyHub.app;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CustomerStorePointsRepository interface extends CrudRepository for managing CustomerStorePoints entities.
 *
 * @author YourName
 */
public interface CustomerStorePointsRepository extends JpaRepository<CustomerStorePoints, Integer> {

    /**
     * Finds a CustomerStorePoints record by the customer and store.
     *
     * @param string The customer's ID.
     * @param storeId    The store's ID.
     * @return The CustomerStorePoints record if found, otherwise null.
     */
    CustomerStorePoints findByCustomerIdAndStoreId(String string, int storeId);

	Optional<CustomerStorePoints> findById(CustomerStorePointsKey key);

	CustomerStorePoints save(ICustomerStorePoints customerStorePoints);
}