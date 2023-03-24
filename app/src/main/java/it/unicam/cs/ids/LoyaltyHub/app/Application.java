package it.unicam.cs.ids.LoyaltyHub.app;

public class Application {
	public void application (String[] args){
		Customer customer = new Customer("Id1","mario rossi","customer@example.com", 0);
	    LoyaltySystem loyaltySystem = new LoyaltySystem();
	
	    // Registra il cliente nel programma di fedeltà
	    loyaltySystem.registerCustomer(customer);
	
	    // Assegna punti fedeltà al cliente dopo un acquisto
	    loyaltySystem.assignLoyaltyPoints(customer, 1000);
	
	    // Riscatta un premio con i punti fedeltà
	    Reward reward = new Reward("Premio esclusivo", 1500);
	    boolean success = loyaltySystem.redeemReward(customer, reward);
	    if (success) {
	        System.out.println("Il premio è stato riscattato con successo!");
	    } else {
	        System.out.println("Punti fedeltà insufficienti per riscattare il premio.");
	
	    }
	}
	
}