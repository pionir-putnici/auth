package com.hellokoding.auth.repository;
import com.hellokoding.auth.model.Dokument;
import com.hellokoding.auth.model.DokumentStavke;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DokumentStavkeRepository extends JpaRepository<DokumentStavke, Long> {
//	Dokument findByNapomena(String dokument);
	
	List<DokumentStavke> findAllByOrderByIdDesc();
	List<DokumentStavke> findByIdDokument(Dokument dokument);
	
    @Query("SELECT t FROM DokumentStavke t where t.artikli.id = :id_roba "
    		+ "and t.magacini.id = :id_magacin and t.aktivan=true order by t.datum "
    		+ " " ) 
    List<DokumentStavke> findArticleInWarehouse(@Param("id_magacin") Long id_magacin,
    		@Param("id_roba") Long id_roba);    

    
    
//	List<DokumentStavke> findByIdRoba();	
//	List<DokumentStavke> findByIdDokument(Long id);
//	List<DokumentStavke> findByIdDokument(String alo);
//	List<DokumentStavke> findByDokument(Dokument aa1);
	
	
	
}
