package com.medicare;
import static org.junit.Assert.assertTrue;  
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.medicare.contactUs.ContactUs;
import com.medicare.contactUs.ContactUsRepository;
import com.medicare.contactUs.ContactUsService;
import com.medicare.contactUs.ContactUsServiceImpl;
import com.medicare.medicines.MedicineRepository;
import com.medicare.medicines.MedicineService;
import com.medicare.medicines.Medicines;



@RunWith(Suite.class)
@SuiteClasses({ })
@SpringBootTest
public class ContactUsTest {
	@Autowired
	ContactUsService cs;
	@Autowired 
	ContactUsRepository cr;

	@Test
	@DisplayName("GET All details")
	public void getallqueriesTest(){

	    List<ContactUs> ks = cs.getQueries();
	 double rs =ks.size();
	 assertTrue(rs>0);
	}
	@Test
	@DisplayName("Insert Message")
	public void contactusinsert() {
		ContactUs cd=new ContactUs();
		cd.setcId(4);
		cd.setName("Jayanth");
		cd.setEmailId("jayanth@gmail.com");
		cd.setContactNo(1234567891);
		cd.setDescription("regarding policies");
		cr.save(cd);
		assertTrue(cd.getcId()>0);
		
	}
}
