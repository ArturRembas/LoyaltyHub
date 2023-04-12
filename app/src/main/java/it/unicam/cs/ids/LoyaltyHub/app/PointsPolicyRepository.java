package it.unicam.cs.ids.LoyaltyHub.app;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PointsPolicyRepository interface extends CrudRepository for managing PointsPolicy entities.
 *
 * @author YourName
 */
public interface PointsPolicyRepository extends JpaRepository<PointsPolicy, Integer> {
}
