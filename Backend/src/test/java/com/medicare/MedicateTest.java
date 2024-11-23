package com.medicare;
import static org.junit.Assert.assertTrue; 
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.medicare.medicines.Medicines;
import com.medicare.medicines.MedicineRepository;
import com.medicare.medicines.MedicineService;
import com.medicare.medicines.MedicineServiceImpl;



@RunWith(Suite.class)
@SuiteClasses({})
@SpringBootTest
public class MedicateTest {
	@Autowired
	MedicineService ms;
	@Autowired 
	MedicineRepository mr;

	@Test
	@DisplayName("GET All Medicines")
	public void getallmedicinesTest(){

	    List<Medicines> ks = ms.getMedicineDetails();
	 double rs =ks.size();
	 assertTrue(rs>0);

	}


	@Test
	@DisplayName("UPDATE Medicines")
	public void updatemedicinedetails() {
		Medicines md =new Medicines();
		md.setMedicineId(42);
		md.setMedicineName("neuro");
		md.setType("ferver");
		md.setPrice(200);
		md.setManufactureDate("05-01-2022");
		md.setExpdate("24-10-2023");
		md.setSeller("NeuroMedicals");
		md.setDescription("used for fever");
		md.setStatus("active");
		md.setType("tablet");
		mr.save(md);
		assertEquals(md.getPrice(),200);
		
		
		
	}

	@Test
	@DisplayName("Delete Medicine")
	public void deletemedicine() {
		Medicines md =new Medicines();
		md.setMedicineId(17);
		ms.deleteMedicines(17);
		assertFalse(mr.existsById(md.getMedicineId()));
		
		
		
	}

	

	@Test
	@DisplayName("GET All MedicineBYID")
	public void Medicineid() {
		Medicines md;
		md=ms.findById(1);
		assertEquals(md.getMedicineName(),"Acetaminophen (Tylenol)");



	}
	@Test
	@DisplayName("Insert Operation")
	public void Medicineinsert() {
		Medicines md=new Medicines();
		md.setMedicineId(5);
		md.setMedicineName("Ativan");
		md.setType("sleeping");
		md.setPrice(500);
		md.setManufactureDate("06-01-2022");
		md.setExpdate("25-10-2023");
		md.setSeller("Lifecheck");
		md.setDescription("trouble sleeping");
		md.setStatus("active");
		mr.save(md);
		assertTrue(md.getMedicineId()>0);
		
	}

}
