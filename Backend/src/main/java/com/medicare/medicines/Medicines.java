package com.medicare.medicines;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Medicines {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int  medicineId;
	@Column(unique=true)
	private String medicineName;	
	private String manufactureDate;	
	private String type;	
	private double price;	
	private String description;	
	private String expdate;
	private String medicineType;
	private String status;
	private String seller;
	
	public Medicines() {
		super();
	}

	public Medicines(int medicineId, String medicineName, String manufactureDate, String type, double price,
			String description, String expdate, String medicineType, String status, String seller) {
		super();
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.manufactureDate = manufactureDate;
		this.type = type;
		this.price = price;
		this.description = description;
		this.expdate = expdate;
		this.medicineType = medicineType;
		this.status = status;
		this.seller = seller;
	}

	public int getMedicineId() {
		return medicineId;
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

	public String getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(String manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getExpdate() {
		return expdate;
	}

	public void setExpdate(String expdate) {
		this.expdate = expdate;
	}

	public String getMedicineType() {
		return medicineType;
	}

	public void setMedicineType(String medicineType) {
		this.medicineType = medicineType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}
	
}
