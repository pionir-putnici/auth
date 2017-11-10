package com.hellokoding.auth.service;


import java.util.List;
import com.hellokoding.auth.model.VrstePaleta;

public interface VrstePaletaService {
			
    void save(VrstePaleta vrstepaleta);

    VrstePaleta findByName(String username);
    
    VrstePaleta findByOne(Long id);
    
    void delete(Long id);

	public List<VrstePaleta> getAllVrstePaleta();
	// public List<Employee> getAllEmployees();
    
    
    
//    void update(VrstePaleta vrstepaleta);
}
