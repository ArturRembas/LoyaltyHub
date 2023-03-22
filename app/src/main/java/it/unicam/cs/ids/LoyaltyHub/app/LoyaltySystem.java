/**
 * 
 */
package it.unicam.cs.ids.LoyaltyHub.app;

/**
 * @author user
 *
 */
public class LoyaltySystem {
	public void registerCustomer(Customer customer) {
        // Implementa il processo di registrazione del cliente al programma di fedeltà
    }

    public void assignLoyaltyPoints(Customer customer, int points) {
        // Implementa il processo di assegnazione dei punti fedeltà al cliente
    	int currentPoints = customer.getLoyaltyPoints();
        int updatedPoints = currentPoints + points;
        customer.setLoyaltyPoints(updatedPoints);

        // Opzionale: invia una notifica al cliente sull'assegnazione dei punti
        System.out.println("Assegnati " + points + " punti fedeltà al cliente " + customer.getEmail() + ". Nuovo saldo: " + updatedPoints);
    }

    public boolean redeemReward(Customer customer, Reward reward) {
        // Implementa il processo di riscatto dei punti fedeltà in cambio di un premio
    	int customerPoints = customer.getLoyaltyPoints();
        int pointsRequired = reward.getPointsRequired();

        if (customerPoints >= pointsRequired) {
            int newLoyaltyPoints = customerPoints - pointsRequired;
            customer.setLoyaltyPoints(newLoyaltyPoints);
            updateDatabase(customer, reward);
            sendNotification(customer, reward);
            return true;
        } else {
            return false;
        }
    }
    
    private void updateDatabase(Customer customer, Reward reward) {
        // Aggiorna il database con il nuovo saldo dei punti del cliente e registra l'azione di riscatto
    }

    private void sendNotification(Customer customer, Reward reward) {
        // Invia una notifica al cliente con i dettagli del riscatto e il nuovo saldo dei punti
    }
}
