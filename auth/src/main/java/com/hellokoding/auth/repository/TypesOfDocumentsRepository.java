package com.hellokoding.auth.repository;
import com.hellokoding.auth.model.TypesOfDocuments;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TypesOfDocumentsRepository extends JpaRepository<TypesOfDocuments, Long> {
	
	TypesOfDocuments findByName(String typesofdocuments);
	
	List<TypesOfDocuments> findAllByOrderByIdDesc();
}
