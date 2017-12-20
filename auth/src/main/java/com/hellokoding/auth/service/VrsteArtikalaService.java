package com.hellokoding.auth.service;

import java.util.List;

import com.hellokoding.auth.model.VrsteArtikala;

public interface VrsteArtikalaService {
			
    void save(VrsteArtikala vrsteArtikala);

    VrsteArtikala findByName(String username);
    
    VrsteArtikala findByOne(Long id);
    
    void delete(Long id);

	public List<VrsteArtikala> getAllVrsteArtikala();

}
