package it.unicam.cs.ids.LoyaltyHub.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * LoyaltyService class manages the logic of the loyalty program.
 */
@Service
public class LoyaltyService {

    private final CustomerRepository customerRepository;
    private final RewardRepository rewardRepository;
    private final PurchaseRepository purchaseRepository;
    private final RedemptionRequestRepository redemptionRequestRepository;

    @Autowired
    public LoyaltyService(CustomerRepository customerRepository, RewardRepository rewardRepository,
                          PurchaseRepository purchaseRepository, RedemptionRequestRepository redemptionRequestRepository) {
        this.customerRepository = customerRepository;
        this.rewardRepository = rewardRepository;
        this.purchaseRepository = purchaseRepository;
        this.redemptionRequestRepository = redemptionRequestRepository;
    }

    // Implement the methods related to the business logic
    public void registerCustomer(Customer customer) {
        customerRepository.save(customer);
    }
    
    public void assignLoyaltyPoints(Purchase purchase) {
        Optional<Customer> customerOpt = customerRepository.findById(purchase.getCustomerId());
        if (customerOpt.isPresent()) {
            Customer customer = customerOpt.get();
            int loyaltyPoints = calculateLoyaltyPoints(purchase.getTotalAmount());
            customer.setLoyaltyPoints(customer.getLoyaltyPoints() + loyaltyPoints);
            customerRepository.save(customer);
        } else {
            throw new IllegalArgumentException("Customer not found");
        }
    }
    
    public Reward redeemLoyaltyPoints(RedemptionRequest redemptionRequest) {
        Optional<Customer> customerOpt = customerRepository.findById(redemptionRequest.getCustomerId());
        if (customerOpt.isPresent()) {
            Customer customer = customerOpt.get();
            if (customer.getLoyaltyPoints() >= redemptionRequest.getPointsToRedeem()) {
                Optional<Reward> rewardOpt = rewardRepository.findById(redemptionRequest.getId());
                if (rewardOpt.isPresent()) {
                    Reward reward = rewardOpt.get();
                    customer.setLoyaltyPoints(customer.getLoyaltyPoints() - redemptionRequest.getPointsToRedeem());
                    customerRepository.save(customer);
                    return reward;
                } else {
                    throw new IllegalArgumentException("Reward not found");
                }
            } else {
                throw new IllegalArgumentException("Insufficient points");
            }
        } else {
            throw new IllegalArgumentException("Customer not found");
        }
    }
    
    private int calculateLoyaltyPoints(double amount) {
        // Implement your own logic to calculate loyalty points based on the purchase amount
        return (int) Math.round(amount / 10);
    }
}


/*
package it.unicam.cs.ids.LoyaltyHub.app;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoyaltyService {

	private final CustomerRepository customerRepository;
    private final RewardRepository rewardRepository;

    @Autowired
    public LoyaltyService(CustomerRepository customerRepository, RewardRepository rewardRepository) {
        this.customerRepository = customerRepository;
        this.rewardRepository = rewardRepository;
    }

    public void registerCustomer(Customer customer) {
        //customerRepository.save(customer);
    	customerRepository.addCustomer(customer);
    }

    public void assignLoyaltyPoints(Purchase purchase) {
        Optional<Customer> customer = customerRepository.findCustomerById(purchase.getCustomerId());
        if (customer != null) {
            int loyaltyPoints = calculateLoyaltyPoints(purchase.getTotalAmount());
            customer.setLoyaltyPoints(customer.getLoyaltyPoints() + loyaltyPoints);
            //customerRepository.save(customer);
            customerRepository.addCustomer(customer);
        } else {
            throw new IllegalArgumentException("Customer not found");
        }
    }

    public Reward redeemLoyaltyPoints(RedemptionRequest redemptionRequest) {
        Optional<Customer> customer = customerRepository.findCustomerById(redemptionRequest.getCustomerId());
        if (customer != null && customer.getLoyaltyPoints() >= redemptionRequest.getPointsToRedeem()) {
            Reward reward = rewardRepository.findRewardByPoints(redemptionRequest.getPointsToRedeem());
            if (reward != null) {
                customer.setLoyaltyPoints(customer.getLoyaltyPoints() - redemptionRequest.getPointsToRedeem());
                customerRepository.save(customer);
                return reward;
            } else {
                throw new IllegalArgumentException("No rewards available for the given points");
            }
        } else {
            throw new IllegalArgumentException("Customer not found or insufficient points");
        }
    }

    private int calculateLoyaltyPoints(double amount) {
        // Implement your own logic to calculate loyalty points based on the purchase amount
        return (int) Math.round(amount / 10);
    }
}
*/