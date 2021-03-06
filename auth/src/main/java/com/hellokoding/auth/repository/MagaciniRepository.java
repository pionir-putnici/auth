package com.hellokoding.auth.repository;

import com.hellokoding.auth.model.Artikli;
import com.hellokoding.auth.model.DokumentStavke;
import com.hellokoding.auth.model.Magacini;
import com.hellokoding.auth.model.Partner;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MagaciniRepository extends JpaRepository<Magacini, Long> {
	
	Magacini findByName(String Magacini);
	
	List<Magacini> rptMagacini();

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
	List<Magacini> findMagacinisWithoutRelations();
	
	@Query(" from Magacini order by name ")	
	List<Magacini> findAllByOrderByNameAsc();
	    
    @Query("SELECT t FROM Magacini t where  "
    		+ " t.partner.id in (:id_partner) "
    		+ " and t.aktivan=true " )     
    List<Magacini> partnerZaMagacin (@Param("id_partner") List<Long> ids_partner);   	
	
	@Query(" from Magacini t where t.objekat=true and aktivan=true")	
	List<Magacini> findInterniObjekti();    
    
//	  @Query("select t from #{#entityName} t where t.attribute = ?1")
//	  List<T> findAllByAttribute(String attribute);
	
//    @Query("SELECT t FROM Todo t WHERE " +
//            "LOWER(t.title) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
//            "LOWER(t.description) LIKE LOWER(CONCAT('%',:searchTerm, '%'))")
//    List<Magacini> findBySearchTerm(@Param("searchTerm") Long searchTerm);
    
}
