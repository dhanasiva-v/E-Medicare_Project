package com.medicare;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.medicare.cart.Cart;
import com.medicare.cart.CartRepository;
import com.medicare.cart.CartService;

import jakarta.transaction.Transactional;



@RunWith(Suite.class)
@SuiteClasses({ })
@SpringBootTest
@Transactional
public class CartTest {
	@Autowired
	CartService cs;
	@Autowired 
	CartRepository cr;

	@Test
	@DisplayName("GET Cart details")
	public void getallcartTest(){

	    List<Cart> as = cs.getCart();
	 double rs =as.size();
	 assertTrue(rs>0);

	}
	
	
	
	@BeforeEach
	public void setUp() {
	    Cart cart = new Cart();
	    cart.setId(2); // Or let the database generate it
	    // Set other necessary fields
	    cr.save(cart);
	}


	



	@Test
	@DisplayName("Delete Medicine")
	public void deletecarttest() {
	Cart ce =new Cart();
	ce.setMedicineId(2);
	cs.deleteCart(2);
	assertFalse(cr.existsById(ce.getMedicineId()));
	}
}
