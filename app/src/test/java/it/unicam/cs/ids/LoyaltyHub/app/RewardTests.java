package it.unicam.cs.ids.LoyaltyHub.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RewardTests {

    private Reward reward;
    private Store store;
    private Customer customer;

    @BeforeEach
    void setUp() {
        store = new Store("Test Store", "123 Test St");
        customer = new Customer("mario.rossi@example.com", "Mario", "Rossi", "via Roma, 1 - ROMA","+39339123456");
        reward = new Reward("Free Coffee", 100);
        reward.setStore(store);
        reward.setCustomer(customer);
    }

    @Test
    void testGettersAndSetters() {
        assertEquals(0, reward.getId()); // The ID is not set yet, so it should be 0
        assertEquals("Free Coffee", reward.getName());
        assertEquals(100, reward.getPointsRequired());
        assertEquals(store, reward.getStore());
        assertEquals(customer, reward.getCustomer());

        reward.setId(1);
        reward.setName("Free Sandwich");
        reward.setPointsRequired(200);
        Store newStore = new Store("New Store", "456 New St");
        Customer newCustomer = new Customer("mario.rossi@example.com", "Mario", "Rossi", "via Roma, 1 - ROMA","+39339123456");
        reward.setStore(newStore);
        reward.setCustomer(newCustomer);

        assertEquals(1, reward.getId());
        assertEquals("Free Sandwich", reward.getName());
        assertEquals(200, reward.getPointsRequired());
        assertEquals(newStore, reward.getStore());
        assertEquals(newCustomer, reward.getCustomer());
    }
}
