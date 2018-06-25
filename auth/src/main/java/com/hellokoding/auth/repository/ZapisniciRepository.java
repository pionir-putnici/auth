package com.hellokoding.auth.repository;
import com.hellokoding.auth.model.Zapisnici;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ZapisniciRepository extends JpaRepository<Zapisnici, String> {
	
	/*Zapisnici findByName(String zapisnici);
	
	List<Zapisnici> findAllByOrderByIdDesc();*/
}
