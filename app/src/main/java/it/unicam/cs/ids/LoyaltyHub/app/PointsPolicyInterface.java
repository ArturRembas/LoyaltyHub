package it.unicam.cs.ids.LoyaltyHub.app;

/**
 * PointsPolicyInterface represents a points policy for a loyalty program.
 */
public interface PointsPolicyInterface {

    /**
     * Calculates the points earned for a given purchase amount.
     *
     * @param purchaseAmount The purchase amount.
     * @return The number of points earned.
     */
    int calculatePoints(double purchaseAmount);
    double getMinimumPurchaseAmount();
    void setMinimumPurchaseAmount(double minimumPurchaseAmount);
    double getPointsPerCurrency();
    void setPointsPerCurrency(double pointsPerCurrency);
    
}
