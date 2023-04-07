package it.unicam.cs.ids.LoyaltyHub.app;

import org.springframework.data.repository.CrudRepository;

/**
 * RewardRepository interface extends CrudRepository for managing Reward entities.
 */
public interface RewardRepository extends CrudRepository<Reward, Integer> {
}