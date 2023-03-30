package it.unicam.cs.ids.LoyaltyHub.app;

import org.springframework.data.repository.CrudRepository;

/**
 * PurchaseRepository interface extends CrudRepository for managing Purchase entities.
 */
public interface PurchaseRepository extends CrudRepository<Purchase, Integer> {
}
