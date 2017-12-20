package com.hellokoding.auth.service;

import java.util.List;

import com.hellokoding.auth.model.VrsteMagacina;

public interface VrsteMagacinaService {
			
    void save(VrsteMagacina vrsteMagacina);

    VrsteMagacina findByName(String username);
    
    VrsteMagacina findByOne(Long id);
    
    void delete(Long id);

	public List<VrsteMagacina> getAllVrsteMagacina();
	
	 public void setVrsteMagacinaInfoById(String nane, String Name, Long id);

}
