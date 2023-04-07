package it.unicam.cs.ids.LoyaltyHub.app;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/**
 * CustomerRepository interface extends CrudRepository for managing Customer entities.
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	// Cerca un cliente in base all'email
    Optional<Customer> findByEmail(String email);
    Optional<Customer> findById(String idCustomer);
}