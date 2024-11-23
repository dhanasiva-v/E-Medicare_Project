package com.medicare.cart;

import com.medicare.medicines.Medicines;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int medicineId;
	private String medicineName;
	private double price;
	private String description;
	private int quantity;
	private String username;

	


	public Cart() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getMedicineId() {
		return medicineId;
	}

	public Cart(int medicineId, String medicineName, double price, String description, int quantity, String username) {
		super();
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
		this.username = username;
	}

	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setId(int i) {
		// TODO Auto-generated method stub
		this.medicineId = i;
	}

	//public Medicines getMedicine() {
	//	return medicine;
	//}
	//
	//public void setMedicine(Medicines medicine) {
	//	this.medicine = medicine;
	//}



}
