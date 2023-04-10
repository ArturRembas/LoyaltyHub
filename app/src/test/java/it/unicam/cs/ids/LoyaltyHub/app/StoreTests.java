package it.unicam.cs.ids.LoyaltyHub.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreTests {

    private Store store;
    private Customer customer;
    private PointsPolicy pointsPolicy;

    @BeforeEach
    void setUp() {
        pointsPolicy = new PointsPolicy();
        store = new Store("Test Store", "123 Test St");
        customer = new Customer("mario.rossi@example.com", "Mario", "Rossi", "via Roma, 1 - ROMA","+39339123456");
        store.setPointsPolicy(pointsPolicy);
    }

    @Test
    void testGettersAndSetters() {
        assertEquals(0, store.getId()); // The ID is not set yet, so it should be 0
        assertEquals("Test Store", store.getName());
        assertEquals("123 Test St", store.getAddress());
        assertEquals(pointsPolicy, store.getPointsPolicy());

        store.setId(1);
        store.setName("New Store");
        store.setAddress("456 New St");
        PointsPolicy newPointsPolicy = new PointsPolicy();
        store.setPointsPolicy(newPointsPolicy);

        assertEquals(1, store.getId());
        assertEquals("New Store", store.getName());
        assertEquals("456 New St", store.getAddress());
        assertEquals(newPointsPolicy, store.getPointsPolicy());
    }

    @Test
    void testAddCustomer() {
        // TODO: Implement this test once the addCustomer method is implemented in the Store class
    }

    @Test
    void testUpdateCustomer() {
        // TODO: Implement this test once the updateCustomer method is implemented in the Store class
    }

    @Test
    void testRemoveCustomer() {
        // TODO: Implement this test once the removeCustomer method is implemented in the Store class
    }
}
