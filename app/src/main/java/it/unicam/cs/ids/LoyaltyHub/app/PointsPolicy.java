package it.unicam.cs.ids.LoyaltyHub.app;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * PointsPolicy class represents the points policy for a store.
 */
@Entity
public class PointsPolicy implements PointsPolicyInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int storeId;
    private double pointsPerCurrency;
    private double minimumPurchaseAmount;

    /**
     * Default constructor for the PointsPolicy class.
     */
    public PointsPolicy() {
    }

    /**
     * Constructs a PointsPolicy instance with the specified store ID, points per currency, and minimum purchase amount.
     *
     * @param storeId              The ID of the store this policy applies to.
     * @param pointsPerCurrency    The number of points earned per unit of currency spent.
     * @param minimumPurchaseAmount The minimum purchase amount required to earn points.
     */
    public PointsPolicy(int storeId, double pointsPerCurrency, double minimumPurchaseAmount) {
        this.storeId = storeId;
        this.pointsPerCurrency = pointsPerCurrency;
        this.minimumPurchaseAmount = minimumPurchaseAmount;
    }

    /**
     * Gets the ID of this points policy.
     *
     * @return The ID of this points policy.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of this points policy.
     *
     * @param id The ID to set for this points policy.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the store ID this points policy applies to.
     *
     * @return The store ID this points policy applies to.
     */
    public int getStoreId() {
        return storeId;
    }

    /**
     * Sets the store ID this points policy applies to.
     *
     * @param storeId The store ID to set for this points policy.
     */
    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    /**
     * Gets the number of points earned per unit of currency spent.
     *
     * @return The number of points earned per unit of currency spent.
     */
    public double getPointsPerCurrency() {
        return pointsPerCurrency;
    }

    /**
     * Sets the number of points earned per unit of currency spent.
     *
     * @param pointsPerCurrency The points per currency to set for this points policy.
     */
    public void setPointsPerCurrency(double pointsPerCurrency) {
        this.pointsPerCurrency = pointsPerCurrency;
    }

    /**
     * Gets the minimum purchase amount required to earn points.
     *
     * @return The minimum purchase amount required to earn points.
     */
    public double getMinimumPurchaseAmount() {
        return minimumPurchaseAmount;
    }

    /**
     * Sets the minimum purchase amount required to earn points.
     *
     * @param minimumPurchaseAmount The minimum purchase amount to set for this points policy.
     */
    public void setMinimumPurchaseAmount(double minimumPurchaseAmount) {
        this.minimumPurchaseAmount = minimumPurchaseAmount;
    }
    /**
     * Calculate points per each purchase.
     *
     * @param purchaseAmount The purchase amount.
     */
    public int calculatePoints(double purchaseAmount) {
        // Calcola i punti guadagnati in base all'importo dell'acquisto e al rapporto punti/valuta
        int pointsEarned = (int) Math.round(purchaseAmount * pointsPerCurrency);

        return pointsEarned;
    }
}
