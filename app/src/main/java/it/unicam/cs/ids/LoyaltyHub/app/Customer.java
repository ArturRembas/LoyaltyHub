/**
 * 
 */
package it.unicam.cs.ids.LoyaltyHub.app;

/**
 * @author user
 *
 */
public class Customer {
	private String email;
    private int loyaltyPoints;

    public Customer(String email, int initialPoints) {
        this.email = email;
        this.loyaltyPoints = initialPoints;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }
    
    public String getEmail () {
    	return this.email;
    }
}
