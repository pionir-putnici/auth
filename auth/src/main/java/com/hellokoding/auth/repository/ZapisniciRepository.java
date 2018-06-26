package com.hellokoding.auth.repository;
import com.hellokoding.auth.model.Zapisnici;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ZapisniciRepository extends JpaRepository<Zapisnici, String> {
	
	Zapisnici findById(Long zapisnik);
	List<Zapisnici> findAllByOrderByIdDesc();
		
//    @Query("SELECT max(t.interniBrojDokumenta)+1  FROM Dokument t where  "
//    		+ " t.typesofdocuments.id = (:idDokumentId)  "
//    		+ " and t.aktivan=true " )     
//    Long max_za_vrstu_dokumenta (@Param("idDokumentId") Long ids_idDokumentId); 
}
