package com.hellokoding.auth.repository;
import com.hellokoding.auth.model.Artikli;
import com.hellokoding.auth.model.Partner;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CostumersRepository extends JpaRepository<Partner, Long> {
	Partner findByName(String customeri);
	List<Partner> findAllByOrderByIdDesc();
	
	@Query(" from Partner order by name ")	
	List<Partner> findAllByOrderByNameAsc();	
}
