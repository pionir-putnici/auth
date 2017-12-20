package com.hellokoding.auth.service;


import java.util.List;
import com.hellokoding.auth.model.Magacini;

public interface MagaciniService {
			
    void save(Magacini magacini);

    Magacini findByName(String username);
    
    Magacini findByOne(Long id);
    
    void delete(Long id);

	public List<Magacini> getAllMagacini();
	
	public List<Magacini> findMagacinisWithoutRelations();
	
//	public List<Magacini> rptMagacini();
	
	// public List<Employee> getAllEmployees();
    
    
    
//    void update(VrstePaleta vrstepaleta);
}
