package com.medicare.cart;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
	
	Cart findByMedicineId(int MedicineId) ;
	
	@Query("SELECT c FROM Cart c WHERE c.username = :username")
	List<Cart> findCartsByUserId(@Param("username") String username);

}