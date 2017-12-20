package com.hellokoding.auth.repository;

import com.hellokoding.auth.model.Artikli;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArtikliRepository extends JpaRepository<Artikli, Long> {
	
	Artikli findByName(String Artikli);
	
	List<Artikli> rptArtikli();

//	@Query("select c from Magacini c WHERE c.aktivan IS EMPTY AND c.vrsteMagacina IS EMPTY")
//	@Query("SELECT DISTINCT u from Magacini u")
	
//	@Query("select p.id, p.code, p.name, ci.name from magacini p "
//			+ "join vrste_magacina ci on ci.id = p.vrste_magacina_id" )
	
//	@Query("select p.id, p.code, p.name from Magacini p "
//			+ " left join p.VrsteMagacina ci " )

// 	@Query("select p.id as id, p.code, p.name, p.remark, p.vrsteMagacina.name, "
//			+ " p.aktivan, p.akcija from Magacini p "
//			+ "  " )
	

	@Query(" from Magacini p "
			+ "  " )	
	
	List<Artikli> findArtikliWithoutRelations();
	
	
//	  @Query("select t from #{#entityName} t where t.attribute = ?1")
//	  List<T> findAllByAttribute(String attribute);
	
//    @Query("SELECT t FROM Todo t WHERE " +
//            "LOWER(t.title) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
//            "LOWER(t.description) LIKE LOWER(CONCAT('%',:searchTerm, '%'))")
//    List<Magacini> findBySearchTerm(@Param("searchTerm") Long searchTerm);
    
}
