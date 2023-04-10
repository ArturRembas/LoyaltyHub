package it.unicam.cs.ids.LoyaltyHub.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointsPolicyTests {

    private PointsPolicy pointsPolicy;

    @BeforeEach
    void setUp() {
        pointsPolicy = new PointsPolicy(1, 100, 10);
    }/*

    @Test
    void testGettersAndSetters() {
        assertEquals(1, pointsPolicy.getId());
        assertEquals(100, pointsPolicy.getSpendingThreshold());
        assertEquals(10, pointsPolicy.getPointsPerThreshold());

        pointsPolicy.setId(2);
        pointsPolicy.setSpendingThreshold(200);
        pointsPolicy.setPointsPerThreshold(20);

        assertEquals(2, pointsPolicy.getId());
        assertEquals(200, pointsPolicy.getSpendingThreshold());
        assertEquals(20, pointsPolicy.getPointsPerThreshold());
    }

    @Test
    void testCalculatePoints() {
        int points = pointsPolicy.calculatePoints(500);
        assertEquals(50, points);

        pointsPolicy.setSpendingThreshold(200);
        pointsPolicy.setPointsPerThreshold(20);
        points = pointsPolicy.calculatePoints(500);
        assertEquals(40, points);
    } */
}
