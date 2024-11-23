package com.medicare.cart;

import java.util.List;

import com.medicare.medicines.Medicines;

public interface CartService {
	void insertCart(Cart cart);
	void addToCart(Cart Citem);
	void deleteCart(int medicineId);
	List<Cart>getCart();
	Cart addProductCart(String username, Cart cart);
	List<Cart> getCartss(String username);

}
