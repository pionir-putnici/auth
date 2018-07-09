package com.hellokoding.auth.repository;
import com.hellokoding.auth.model.Dokument;
import com.hellokoding.auth.model.TypesOfDocuments;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TypesOfDocumentsRepository extends JpaRepository<TypesOfDocuments, Long> {
	
	TypesOfDocuments findByName(String typesofdocuments);
	
	List<TypesOfDocuments> findAllByOrderByIdDesc();
	
    @Query("SELECT t FROM TypesOfDocuments t where t.type = '2'  "
    		+ "and t.aktivan=true order by t.id desc "
    		+ " " ) 
    List<TypesOfDocuments> dokTypeIs2();

    @Query("SELECT t FROM TypesOfDocuments t where t.type != '2'  "
    		+ "and t.aktivan=true order by t.id desc "
    		+ " " ) 
    List<TypesOfDocuments> dokTypeNot2();
    
    
}
