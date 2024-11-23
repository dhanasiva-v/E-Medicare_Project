package com.medicare.billing;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity
public class Billing {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int billingId;
	private int billingMedicineId;
	private String billingDescription;
	private String billingMedicineName;
	private double billingPrice;
	private int billingQuantity;
	private String billingUserName;
	private LocalDate billingDate;
	private double billingSubtotal;

	public Billing() {
		super();
	}

	@PrePersist
	@PreUpdate
	public void calculateSubtotal() {
		this.billingSubtotal = this.billingPrice * this.billingQuantity;
		if (this.billingDate == null) {
			this.billingDate = LocalDate.now();
		}
	}

	public Billing(int billingId, int billingMedicineId, String billingDescription, String billingMedicineName,
			double billingPrice, int billingQuantity, String billingUserName, LocalDate billingDate,
			double billingSubtotal) {
		super();
		this.billingId = billingId;
		this.billingMedicineId = billingMedicineId;
		this.billingDescription = billingDescription;
		this.billingMedicineName = billingMedicineName;
		this.billingPrice = billingPrice;
		this.billingQuantity = billingQuantity;
		this.billingUserName = billingUserName;
		this.billingDate = billingDate;
		this.billingSubtotal = billingSubtotal;
	}

	public int getBillingId() {
		return billingId;
	}

	public void setBillingId(int billingId) {
		this.billingId = billingId;
	}

	public int getBillingMedicineId() {
		return billingMedicineId;
	}

	public void setBillingMedicineId(int billingMedicineId) {
		this.billingMedicineId = billingMedicineId;
	}

	public String getBillingDescription() {
		return billingDescription;
	}

	public void setBillingDescription(String billingDescription) {
		this.billingDescription = billingDescription;
	}

	public String getBillingMedicineName() {
		return billingMedicineName;
	}

	public void setBillingMedicineName(String billingMedicineName) {
		this.billingMedicineName = billingMedicineName;
	}

	public double getBillingPrice() {
		return billingPrice;
	}

	public void setBillingPrice(double billingPrice) {
		this.billingPrice = billingPrice;
	}

	public int getBillingQuantity() {
		return billingQuantity;
	}

	public void setBillingQuantity(int billingQuantity) {
		this.billingQuantity = billingQuantity;
	}

	public String getBillingUserName() {
		return billingUserName;
	}

	public void setBillingUserName(String billingUserName) {
		this.billingUserName = billingUserName;
	}

	public LocalDate getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(LocalDate billingDate) {
		this.billingDate = billingDate;
	}

	public double getBillingSubtotal() {
		return billingSubtotal;
	}

	public void setBillingSubtotal(double billingSubtotal) {
		this.billingSubtotal = billingSubtotal;
	}



}
