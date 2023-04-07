package it.unicam.cs.ids.LoyaltyHub.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * LoyaltyController class handles RESTful API requests for the loyalty system.
 */
@RestController
@RequestMapping("/loyalty")
public class LoyaltyController {

    @Autowired
    private LoyaltyService loyaltyService;

    /**
     * Registers a new customer.
     *
     * @param customer the customer object to be registered
     * @return the registered customer object
     */
    @PostMapping("/register")
    public Customer registerCustomer(@RequestBody Customer customer) {
        return loyaltyService.registerCustomer(customer);
    }

    /**
     * Assigns loyalty points to a customer for a specific store.
     *
     * @param customerId      the ID of the customer
     * @param storeId         the ID of the store
     * @param purchaseAmount  the purchase amount for calculating points
     * @return the updated CustomerStorePoints object
     */
    @PostMapping("/assign-points/customer/{customerId}/store/{storeId}")
    public CustomerStorePoints assignLoyaltyPoints(@PathVariable String customerId, @PathVariable int storeId, @RequestBody double purchaseAmount) {
        return loyaltyService.assignLoyaltyPoints(customerId, storeId, purchaseAmount);
    }

    /**
     * Redeems a reward for a customer in a specific store.
     *
     * @param customerId the ID of the customer
     * @param storeId    the ID of the store
     * @param rewardId   the ID of the reward to be redeemed
     * @return the updated CustomerStorePoints object
     */
    @PostMapping("/redeem-reward/customer/{customerId}/store/{storeId}/reward/{rewardId}")
    public CustomerStorePoints redeemReward(@PathVariable String customerId, @PathVariable int storeId, @PathVariable int rewardId) {
        return loyaltyService.redeemReward(customerId, storeId, rewardId);
    }

    /**
     * Retrieves the loyalty points for a specific customer in a specific store.
     *
     * @param customerId the ID of the customer
     * @param storeId    the ID of the store
     * @return the CustomerStorePoints object
     */
    @GetMapping("/points/customer/{customerId}/store/{storeId}")
    public ICustomerStorePoints getCustomerStorePoints(@PathVariable String customerId, @PathVariable int storeId) {
        return loyaltyService.getCustomerStorePoints(customerId, storeId);
    }
}
