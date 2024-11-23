package com.medicare;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.medicare.billing.Billing;

class BillingTest {

	@Autowired
    private Billing billing;

    @BeforeEach
    void setUp() {
        billing = new Billing();
    }

    @Test
    void testDefaultConstructor() {
        assertNotNull(billing);
        assertEquals(0, billing.getBillingId());
        assertEquals(0, billing.getBillingMedicineId());
        assertNull(billing.getBillingDescription());
        assertNull(billing.getBillingMedicineName());
        assertEquals(0.0, billing.getBillingPrice());
        assertEquals(0, billing.getBillingQuantity());
        assertNull(billing.getBillingUserName());
        assertNull(billing.getBillingDate());
        assertEquals(0.0, billing.getBillingSubtotal());
    }

    @Test
    void testParameterizedConstructor() {
        LocalDate date = LocalDate.now();
        billing = new Billing(1, 100, "Test description", "Medicine A",
                50.0, 2, "User1", date, 0.0);
        
        assertEquals(1, billing.getBillingId());
        assertEquals(100, billing.getBillingMedicineId());
        assertEquals("Test description", billing.getBillingDescription());
        assertEquals("Medicine A", billing.getBillingMedicineName());
        assertEquals(50.0, billing.getBillingPrice());
        assertEquals(2, billing.getBillingQuantity());
        assertEquals("User1", billing.getBillingUserName());
        assertEquals(date, billing.getBillingDate());
    }

    @Test
    void testCalculateSubtotal() {
        billing.setBillingPrice(20.0);
        billing.setBillingQuantity(3);
        billing.calculateSubtotal();

        assertEquals(60.0, billing.getBillingSubtotal());
    }

    @Test
    void testCalculateSubtotalWithNullDate() {
        billing.setBillingPrice(10.0);
        billing.setBillingQuantity(5);
        billing.setBillingDate(null);
        billing.calculateSubtotal();

        assertEquals(50.0, billing.getBillingSubtotal());
        assertNotNull(billing.getBillingDate());
        assertEquals(LocalDate.now(), billing.getBillingDate());
    }

    @Test
    void testSettersAndGetters() {
        billing.setBillingId(2);
        billing.setBillingMedicineId(101);
        billing.setBillingDescription("Another description");
        billing.setBillingMedicineName("Medicine B");
        billing.setBillingPrice(25.0);
        billing.setBillingQuantity(4);
        billing.setBillingUserName("User2");
        billing.setBillingDate(LocalDate.of(2024, 1, 1));
        
        assertEquals(2, billing.getBillingId());
        assertEquals(101, billing.getBillingMedicineId());
        assertEquals("Another description", billing.getBillingDescription());
        assertEquals("Medicine B", billing.getBillingMedicineName());
        assertEquals(25.0, billing.getBillingPrice());
        assertEquals(4, billing.getBillingQuantity());
        assertEquals("User2", billing.getBillingUserName());
        assertEquals(LocalDate.of(2024, 1, 1), billing.getBillingDate());
    }
}
