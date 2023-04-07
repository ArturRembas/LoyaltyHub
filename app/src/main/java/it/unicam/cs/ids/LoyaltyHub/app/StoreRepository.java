package it.unicam.cs.ids.LoyaltyHub.app;

import org.springframework.data.repository.CrudRepository;

/**
 * StoreRepository interface extends CrudRepository for managing Store entities.
 *
 * @author YourName
 */
public interface StoreRepository extends CrudRepository<Store, Integer> {

    /**
     * Finds a Store record by its name.
     *
     * @param name The name of the store.
     * @return The Store record if found, otherwise null.
     */
    Store findByName(String name);
}