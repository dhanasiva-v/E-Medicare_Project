package com.medicare.billing;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicare.cart.Cart;

@Service
public class BillingService {
    @Autowired
    private BillingRepository billingRepository;

    public List<Billing> saveBilling(List<Cart> carts) {
    	billingRepository.deleteAllBillings();
    	List<Billing> billingList=new ArrayList<>();
    	for (Cart cart : carts) {
    		Billing b=new Billing();
    		b.setBillingMedicineId(cart.getMedicineId());
    		b.setBillingDescription(cart.getDescription());
    		b.setBillingMedicineName(cart.getMedicineName());
    		b.setBillingPrice(cart.getPrice());
    		b.setBillingQuantity(cart.getQuantity());
    		b.setBillingUserName(cart.getUsername());
    		b.setBillingSubtotal(cart.getQuantity()*cart.getPrice());
    		billingList.add(b);
            billingRepository.save(b);
		}
    	return billingList;
    }

    public List<Billing> getAllBillings() {
        return billingRepository.findAll();
    }

    public Billing getBillingById(int billingId) {
        return billingRepository.findById(billingId).orElse(null);
    }

    public void deleteBilling(int medicineId) {
        billingRepository.deleteBymedicineId(medicineId);
    }
    
    public List<Billing> getBillingsByDateAndUser(LocalDate billingDate, String billingUserName) {
        return billingRepository.findByBillingDateAndBillingUserName(billingDate, billingUserName);
    }

	public void setBillingRepository(BillingRepository billingRepository) {
		this.billingRepository = billingRepository;
	}

    
}

