package com.hellokoding.auth.service;

import java.util.List;

import com.hellokoding.auth.model.JediniceMera;


public interface JediniceMeraService {
			
    void save(JediniceMera jediniceMera);

    JediniceMera findByName(String username);
    
    JediniceMera findByOne(Long id);
    
    void delete(Long id);

	public List<JediniceMera> getAllJediniceMera();

}
