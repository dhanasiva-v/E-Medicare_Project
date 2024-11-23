package com.medicare.billing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicare.cart.Cart;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/billing")
public class BillingController {
    
	@Autowired
    private BillingService billingService;
    
    @PostMapping("/cre")
    public ResponseEntity<List<Billing>> createBilling(@RequestBody List<Cart> carts) {
        System.out.println("Received request with carts: " + carts);
        List<Billing> billings = billingService.saveBilling(carts);
        return ResponseEntity.ok(billings);
    }

    @GetMapping
    public List<Billing> getAllBillings() {
        return billingService.getAllBillings();
    }

    @GetMapping("/{id}")
    public Billing getBillingById(@PathVariable int id) {
        return billingService.getBillingById(id);
    }

    @DeleteMapping("/{medicineId}")
    public void deleteBilling(@PathVariable int medicineId) {
        billingService.deleteBilling(medicineId);
    }
    
    
}

