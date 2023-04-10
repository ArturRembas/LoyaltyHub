package it.unicam.cs.ids.LoyaltyHub.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RedemptionRequestTests {

    private RedemptionRequest redemptionRequest;

    @BeforeEach
    void setUp() {
        redemptionRequest = new RedemptionRequest(1, 1, 1, 100, "2023-04-15");
    }

    @Test
    void testGettersAndSetters() {
        assertEquals(1, redemptionRequest.getId());
        assertEquals(1, redemptionRequest.getCustomerId());
        assertEquals(100, redemptionRequest.getPointsToRedeem());
        assertEquals("2023-04-15", redemptionRequest.getDate());
        assertFalse(redemptionRequest.isApproved());

        redemptionRequest.setId(2);
        redemptionRequest.setCustomerId(2);
        redemptionRequest.setPointsToRedeem(200);
        redemptionRequest.setDate("2023-05-01");
        redemptionRequest.setApproved(true);

        assertEquals(2, redemptionRequest.getId());
        assertEquals(2, redemptionRequest.getCustomerId());
        assertEquals(200, redemptionRequest.getPointsToRedeem());
        assertEquals("2023-05-01", redemptionRequest.getDate());
        assertTrue(redemptionRequest.isApproved());
    }

    @Test
    void testApprove() {
        assertFalse(redemptionRequest.isApproved());
        redemptionRequest.approve();
        assertTrue(redemptionRequest.isApproved());
    }
}
