package com.medicare.billing;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public interface BillingRepository extends JpaRepository<Billing, Integer> {

	@Query("SELECT b FROM Billing b WHERE b.billingDate = :billingDate AND b.billingUserName = :billingUserName")
	List<Billing> findByBillingDateAndBillingUserName(@Param("billingDate") LocalDate billingDate,
			@Param("billingUserName") String billingUserName);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM Billing", nativeQuery = true)
	void deleteAllBillings();

	@Modifying
	@Transactional
	@Query("DELETE FROM Billing b WHERE b.billingMedicineId = ?1")
	void deleteBymedicineId(int medicineId);

}
