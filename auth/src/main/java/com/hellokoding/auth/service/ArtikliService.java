package com.hellokoding.auth.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.hellokoding.auth.model.Artikli;



public interface ArtikliService {
			
    void save(Artikli artikli);

    Artikli findByName(String username);
    
    Artikli findByOne(Long id);
    
    @Secured("ROLE_ADMIN")
    void delete(Long id);

	public List<Artikli> getAllArtikli();

}
