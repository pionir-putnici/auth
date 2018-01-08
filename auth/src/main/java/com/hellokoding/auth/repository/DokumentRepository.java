package com.hellokoding.auth.repository;
import com.hellokoding.auth.model.Dokument;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DokumentRepository extends JpaRepository<Dokument, Long> {
//	Dokument findByNapomena(String dokument);
	Dokument findById(Long dokument);
	List<Dokument> findAllByOrderByIdDesc();
	
	
}
