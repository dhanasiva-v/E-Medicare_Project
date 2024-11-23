package com.medicare.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicare.medicines.MedicineService;
import com.medicare.medicines.Medicines;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v5")

public class Cartcontroller {
	
	@Autowired
private CartService cartService;
	@Autowired
private MedicineService medicineService;

public Cartcontroller(CartService cartService,MedicineService medicineService) {
	super();
	this.cartService = cartService;
	this.medicineService = medicineService;
}

@GetMapping("/cart")
public List<Cart> getCart(){
	List<Cart> Cart = cartService.getCart();
	return Cart;
}


@GetMapping("/cartslist/{username}")
public ResponseEntity<List<Cart>> getCartsss(@PathVariable String username){
	List<Cart> carts = cartService.getCartss(username);
	return new ResponseEntity<List<Cart>>(carts,HttpStatus.OK);
}




@PostMapping("/cart/{username}")
public ResponseEntity<Cart> addProductCart(@PathVariable("username") String username, @RequestBody Cart cart) {
	Cart m =cartService.addProductCart(username,cart);
	return new ResponseEntity<Cart>(m, HttpStatus.OK);
}


@GetMapping("/cart/{username}/{medicineId}")
public Cart buyMed(@PathVariable("username") String username,@PathVariable("medicineId") int medicineId) { 
	Medicines M =medicineService.findById(medicineId);
	Cart Citem = new Cart();
	Citem.setMedicineId(medicineId);
	Citem.setMedicineName(M.getMedicineName());
	Citem.setDescription(M.getDescription());
	Citem.setPrice(M.getPrice());
	cartService.addProductCart(username,Citem);
	return Citem;
}
//@GetMapping("/cart/{user}/{medicineId}")
//public Cart buyMed(@PathVariable("user") String username,@PathVariable("medicineId") int medicineId) { 
//	Medicines M =medicineService.findById(medicineId);
//	Cart Citem = new Cart();
//	Citem.setMedicineId(medicineId);
//	Citem.setMedicineName(M.getMedicineName());
//	Citem.setDescription(M.getDescription());
//	Citem.setPrice(M.getPrice());
//	cartService.addProductCart(username,Citem);
//	return Citem;
//}


@DeleteMapping("/cart/{medicineId}")
public ResponseEntity<Object> deleteCart(@PathVariable("medicineId") int medicineId) {
	cartService.deleteCart(medicineId);
	return new ResponseEntity<>("deleted successsfully", HttpStatus.OK);
}
}

