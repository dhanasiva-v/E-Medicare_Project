package com.medicare.cart;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicare.billing.BillingRepository;
import com.medicare.user.User;
import com.medicare.user.UserRepository;
@Service
public class CartServiceImpl implements CartService {
	@Autowired
private CartRepository cartRepository;
@Autowired
private UserRepository userRepository;
@Autowired
private BillingRepository billingRepository;

	

	public CartServiceImpl(CartRepository cartRepository) {
	super();
	this.cartRepository = cartRepository;
}

	@Override
	public void addToCart(Cart Citem) {
		cartRepository.save(Citem);
	}

	@Override
	public void deleteCart(int medicineId) {
		billingRepository.deleteBymedicineId(medicineId);
	cartRepository.deleteById(medicineId);
		
	}

	@Override
	public List<Cart> getCart() {
		List<Cart> cart = cartRepository.findAll();
		return cart;
	}

	@Override
	public void insertCart(Cart cart) {
		cartRepository.save(cart);
		
	}

	@Override
	public Cart addProductCart(String username, Cart cart) {
         User u=userRepository.findByUsername(username);
         System.out.println(u.getUsername() + cart.getMedicineName());
         if(u!=null) {
        	 cart.setUsername(username);
        	 Cart ct=cartRepository.save(cart);
        	 System.out.println(ct.getMedicineId() + " " + ct.getMedicineName());
        	 return ct;
         }
		return null;
	}

	@Override
	public List<Cart> getCartss(String username) {
		User u=userRepository.findByUsername(username);
		return cartRepository.findCartsByUserId(u.getUsername()) ;
	} 

/*	@Override
	public Cart findById(int medicineId) {
		// TODO Auto-generated method stub
		Cart C = CartRepository.findByMedicineId(medicineId);
		return C;
	} */
}

