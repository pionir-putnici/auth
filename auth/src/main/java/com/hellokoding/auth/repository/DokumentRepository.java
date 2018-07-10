package com.hellokoding.auth.repository;
import com.hellokoding.auth.model.Dokument;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DokumentRepository extends JpaRepository<Dokument, Long> {

	//	Dokument findByNapomena(String dokument);
	
	Dokument findById(Long dokument);
	List<Dokument> findAllByOrderByIdDesc();
		
    @Query("SELECT max(t.interniBrojDokumenta)+1  FROM Dokument t where  "
    		+ " t.typesofdocuments.id = (:idDokumentId)  "
    		+ " and t.aktivan=true " )     
    Long max_za_vrstu_dokumenta (@Param("idDokumentId") Long ids_idDokumentId); 
        
    // @Query("UPDATE Dokument t SET t.iznos= ?1 WHERE st.sname= ?2");
    
    @Query("SELECT t FROM Dokument t where t.typesofdocuments.type <> '2'  "
    		+ "and t.aktivan=true  order by t.id " //  order by t.id desc
    		+ " " ) 
    List<Dokument> findDokTypeNot2();        

    @Query("SELECT t FROM Dokument t where t.typesofdocuments.type = '2'  "
    		+ "and t.aktivan=true order by t.id " //  order by t.id desc
    		+ " " ) 
    List<Dokument> findDokTypeIs2();       
}
