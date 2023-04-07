package it.unicam.cs.ids.LoyaltyHub.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void testCustomerCreation() {
        Customer customer = new Customer("mario.rossi@example.com", "Mario", "Rossi", "via Roma, 1 - ROMA","+39339123456");

        assertEquals("Mario", customer.getName());
        assertEquals("Rossi", customer.getSurname());
        assertEquals("mario.rossi@example.com", customer.getEmail());
    }

}
