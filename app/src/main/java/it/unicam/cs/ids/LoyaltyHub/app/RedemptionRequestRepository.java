package it.unicam.cs.ids.LoyaltyHub.app;

import org.springframework.data.repository.CrudRepository;

/**
 * RedemptionRequestRepository interface extends CrudRepository for managing RedemptionRequest entities.
 */
public interface RedemptionRequestRepository extends CrudRepository<RedemptionRequest, Integer> {
}
