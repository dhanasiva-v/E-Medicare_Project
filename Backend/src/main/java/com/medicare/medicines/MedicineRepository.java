package com.medicare.medicines;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface MedicineRepository extends JpaRepository<Medicines, Integer> {

	/*static Medicines getMedicine(int medicineId) {
		// TODO Auto-generated method stub
		return null;
	}*/
	Medicines findByMedicineId(int MedicineId);
	
	List<Medicines> findByMedicineType(String medicineType);
	
	@Query("SELECT DISTINCT m.medicineType FROM Medicines m")
	List<String> findDistinctMedicineTypes();



}
