package com.hellokoding.auth.repository;
import com.hellokoding.auth.model.Dokument;
import com.hellokoding.auth.model.DokumentStavke;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DokumentStavkeRepository extends JpaRepository<DokumentStavke, Long> {
//	Dokument findByNapomena(String dokument);
	
	List<DokumentStavke> findAllByOrderByIdDesc();
	List<DokumentStavke> findByIdDokument(Dokument dokument);
//	List<DokumentStavke> findByIdDokument(Long id);
//	List<DokumentStavke> findByIdDokument(String alo);
//	List<DokumentStavke> findByDokument(Dokument aa1);
	
	
	
}
