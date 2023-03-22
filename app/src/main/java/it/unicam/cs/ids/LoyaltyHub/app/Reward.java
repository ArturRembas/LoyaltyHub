/**
 * 
 */
package it.unicam.cs.ids.LoyaltyHub.app;

/**
 * @author user
 *
 */
public class Reward {
	private String name;
    private int pointsRequired;

    public Reward(String name, int pointsRequired) {
        this.name = name;
        this.pointsRequired = pointsRequired;
    }

    public String getName() {
        return name;
    }

    public int getPointsRequired() {
        return pointsRequired;
    }
}
