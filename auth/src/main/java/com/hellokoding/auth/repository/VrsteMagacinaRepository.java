package com.hellokoding.auth.repository;


import com.hellokoding.auth.model.VrsteMagacina;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface VrsteMagacinaRepository extends JpaRepository<VrsteMagacina, Long> {
	VrsteMagacina findByName(String vrsteMagacina);
	
	@Modifying
	@Query("update VrsteMagacina u set u.code = ?1, u.name = ?2 where u.id = ?3")
	void setVrsteMagacinaInfoById(String code, String name, Long id);
}
