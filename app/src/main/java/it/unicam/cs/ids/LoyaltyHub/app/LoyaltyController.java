package it.unicam.cs.ids.LoyaltyHub.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The LoyaltyController class is responsible for handling incoming HTTP requests related to the
 * loyalty system. It serves as the main entry point for clients to interact with the loyalty system,
 * exposing RESTful endpoints for creating, updating, and querying various entities in the system,
 * such as customers, rewards, and redemption requests.
 * <p>
 * This class uses the services provided by the ILoyaltySystem, ICustomer, IReward, and other interfaces
 * to perform the necessary operations for managing the loyalty program. It translates incoming HTTP
 * requests into calls to the appropriate service methods and converts the results of these calls into
 * HTTP responses that can be returned to the client.
 * <p>
 * By delegating the actual processing of requests to the service layer, the LoyaltyController ensures
 * a clean separation of concerns between the web and business logic layers of the application. This
 * design makes it easier to maintain and extend the application, as changes to the underlying business
 * logic or data storage mechanisms should not impact the way that clients interact with the system.
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
     * Add a new PointsPolicy.
     *
     * @param 
     * @return the registered PointsPolicy object
     */
    @PostMapping("/policy-add")
    public PointsPolicy addPointsPolicy(@RequestBody PointsPolicy pointsPolicy) {
    	return loyaltyService.addPointsPolicy(pointsPolicy);
    }
    
    /**
     * Add a new store.
     *
     * @param store the store object to add
     * @return the registered store object
     */
    @PostMapping("/store-add")
    public Store addStore(@RequestBody Store store) {
    	return loyaltyService.addStore(store);
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
    
    @PutMapping("/update-customer/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable String customerId, @RequestBody Customer updatedCustomer) {
        if (!customerId.equals(updatedCustomer.getId())) {
            return ResponseEntity.badRequest().build();
        }
        Customer updated = loyaltyService.updateCustomer(updatedCustomer);
        return ResponseEntity.ok(updated);
    }
}
