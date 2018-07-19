package com.hellokoding.auth.repository;
import com.hellokoding.auth.model.Dokument;
import com.hellokoding.auth.model.DokumentStavke;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
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

    @Query("SELECT t FROM DokumentStavke t where t.artikli.id = :id_roba "
    		+ "and t.magacini.id = :id_magacin and datum between :oddana and :dodana and t.aktivan=true order by t.datum "
    		+ " " ) 
    List<DokumentStavke> findArticleInWarehouseForDate(@Param("id_magacin") Long id_magacin,
    		@Param("id_roba") Long id_roba, @Param("oddana") String oddana, @Param("dodana") String dodana);   

    
    @Query("SELECT t FROM DokumentStavke t where  "
    		+ " t.magacini.id in (:id_magacin) and "
    		+ " t.artikli.id in (:id_roba) "
    		+ " and t.idDokument.datum between :oddana and :dodana and t.aktivan=true " 
    		+ " and t.idDokument.status=1 order by t.idDokument.magacini.code, t.artikli.code, t.idDokument.datum" )     
    List<DokumentStavke> k1 (@Param("id_magacin") List<Long> ids_magacin, @Param("id_roba") List<Long> ids_artikli, 
    		@Param("oddana") Date oddana, @Param("dodana") Date dodana);   

    
    @Query("SELECT t FROM DokumentStavke t where  "
    		+ " t.idDokument.partner.id in (:id_magacin) and "
    		+ " t.artikli.id in (:id_roba) "
    		+ " and t.idDokument.datum between :oddana and :dodana and t.aktivan=true order by t.idDokument.partner.code, t.artikli.code, t.idDokument.datum" )     
    List<DokumentStavke> k1p (@Param("id_magacin") List<Long> ids_magacin, @Param("id_roba") List<Long> ids_artikli, 
    		@Param("oddana") Date oddana, @Param("dodana") Date dodana);       
    
        
    @Query("SELECT t FROM DokumentStavke t where  "
    		+ " t.idDokument.partner.id in (:id_magacin) and "
    		+ " t.artikli.id in (:id_roba) "
    		+ " and t.idDokument.datum between :oddana and :dodana and t.aktivan=true and t.idDokument.status=1 order by t.idDokument.partner.code,  t.idDokument.magacini.code, t.artikli.code, t.idDokument.datum" )     
    List<DokumentStavke> k1pm (@Param("id_magacin") List<Long> ids_magacin, @Param("id_roba") List<Long> ids_artikli, 
    		@Param("oddana") Date oddana, @Param("dodana") Date dodana);       
    
    
    @Query("SELECT t FROM DokumentStavke t where  "
    		+ " t.magacini.id in (:id_magacin) and "
    		+ " t.artikli.id in (:id_roba) "
    		+ " and datum between :oddana and :dodana and t.aktivan=true order by t.magacini.code, t.artikli.code, t.datum" )     
    List<DokumentStavke> k3 (@Param("id_magacin") List<Long> ids_magacin, @Param("id_roba") List<Long> ids_artikli, 
    		@Param("oddana") LocalDate oddana, @Param("dodana") LocalDate dodana);     

    @Query("SELECT t FROM DokumentStavke t where  "
    		+ " t.magacini.id in (:id_magacin) and "
    		+ " t.artikli.id in (:id_roba) "
    		+ " and datum > :oddana and datum < :dodana and t.aktivan=true order by t.magacini.code, t.artikli.code, t.datum" )     
    List<DokumentStavke> k2 (@Param("id_magacin") List<Long> ids_magacin, @Param("id_roba") List<Long> ids_artikli, 
    		@Param("oddana") String oddana, @Param("dodana") String dodana);   
    
    @Query("SELECT sum(t.iznos)  FROM DokumentStavke t where  "
    		+ " t.idDokument.id = (:idDokumentId)  "
    		+ " and t.aktivan=true " )     
    BigDecimal sum_zaglavlje (@Param("idDokumentId") Long ids_idDokumentId); 
    
    // List<User> findNotActivatedUsersByCreationDateBefore(LocalDate localDate);
    
    
 //   @NamedQuery(name = Department.getDepartmentsByIds, query = "SELECT tbl FROM Department tbl where tbl.id in (:departmentsIds)")   ; 
    

    //    @Query("SELECT t FROM DokumentStavke t where :conditions  "
//    		+ " " ) 
//    List<DokumentStavke> upitKonacni(
//    		@Param("conditions") String conditions);       
    	
	
}
