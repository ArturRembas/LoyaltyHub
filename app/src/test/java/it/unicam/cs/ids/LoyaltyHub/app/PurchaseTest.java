package it.unicam.cs.ids.LoyaltyHub.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseTest {
    private IPurchase purchase;

    @BeforeEach
    void setUp() {
        purchase = new Purchase();
    }

    @Test
    void testGetId() {
        int id = 1;
        purchase.setId(id);
        assertEquals(id, purchase.getId());
    }

    @Test
    void testSetId() {
        int id = 2;
        purchase.setId(id);
        assertEquals(id, purchase.getId());
    }

    @Test
    void testGetAmount() {
        double amount = 25.50;
        purchase.setTotalAmount(amount);
        assertEquals(amount, purchase.getTotalAmount());
    }

    @Test
    void testSetAmount() {
        double amount = 35.75;
        purchase.setTotalAmount(amount);
        assertEquals(amount, purchase.getTotalAmount());
    }

}
