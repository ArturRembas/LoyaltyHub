package it.unicam.cs.ids.LoyaltyHub.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loyalty")
public class LoyaltyController {
	private final LoyaltyService loyaltyService;

    @Autowired
    public LoyaltyController(LoyaltyService loyaltyService) {
        this.loyaltyService = loyaltyService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerCustomer(@RequestBody Customer customer) {
        try {
            loyaltyService.registerCustomer(customer);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/assignPoints")
    public ResponseEntity<?> assignLoyaltyPoints(@RequestBody Purchase purchase) {
        try {
            loyaltyService.assignLoyaltyPoints(purchase);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/redeemPoints")
    public ResponseEntity<?> redeemLoyaltyPoints(@RequestBody RedemptionRequest redemptionRequest) {
        try {
            Reward reward = loyaltyService.redeemLoyaltyPoints(redemptionRequest);
            return ResponseEntity.status(HttpStatus.OK).body(reward);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
