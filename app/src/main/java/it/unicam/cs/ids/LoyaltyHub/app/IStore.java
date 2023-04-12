package it.unicam.cs.ids.LoyaltyHub.app;

/**
 * IStore represents a store in the loyalty system.
 */
public interface IStore {

    /**
     * Adds a customer to the store's loyalty program.
     *
     * @param customer The customer to add.
     */
    void addCustomer(Customer customer);

    /**
     * Updates a customer's information in the store's loyalty program.
     *
     * @param customer The customer with updated information.
     */
    void updateCustomer(Customer customer);

    /**
     * Removes a customer from the store's loyalty program.
     *
     * @param customer The customer to remove.
     */
    void removeCustomer(Customer customer);

    PointsPolicy getPointsPolicy();

}
