/**
 * 
 */
package it.unicam.cs.ids.LoyaltyHub.app;

/**
 * @author user
 *
 */
public class Customer {
	private String customerId;
	private String name;
	private String email;
    private int loyaltyPoints;

    public Customer(String customerId, String name, String email, int initialPoints) {
        this.customerId = customerId;
        this.name = name;
    	this.email = email;
        this.loyaltyPoints = initialPoints;
    }

    public String getCustomerId () {
    	return customerId;
    }
    
    //public void setCustomerId 
    
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
