package it.unicam.cs.ids.LoyaltyHub.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * CustomerRepository interface extends CrudRepository for managing Customer entities.
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	// Cerca un cliente in base all'email
    Optional<Customer> findByEmail(String email);
}


/*
package it.unicam.cs.ids.LoyaltyHub.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerRepository {

	private List<Customer> customers;

    public CustomerRepository() {
        this.customers = new ArrayList<>();
    }

    // Aggiungi un nuovo cliente al repository
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // Trova un cliente nel repository utilizzando l'ID
    public Optional<Customer> findCustomerById(String id) {
        return customers.stream().filter(customer -> customer.getCustomerId() == id).findFirst();
    }

    // Aggiorna un cliente nel repository
    public void updateCustomer(Customer updatedCustomer) {
        int index = -1;
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCustomerId() == updatedCustomer.getCustomerId()) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            customers.set(index, updatedCustomer);
        }
    }

    // Rimuovi un cliente dal repository utilizzando l'ID
    public void removeCustomer(String id) {
        customers.removeIf(customer -> customer.getCustomerId() == id);
    }

    // Recupera tutti i clienti dal repository
    public List<Customer> findAllCustomers() {
        return new ArrayList<>(customers);
    }
}
*/