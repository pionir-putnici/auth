package com.hellokoding.auth.service;

import java.util.List;

import com.hellokoding.auth.model.PoreskeGrupe;


public interface PoreskeGrupeService {
			
    void save(PoreskeGrupe poreskeGrupe);

    PoreskeGrupe findByName(String username);
    
    PoreskeGrupe findByOne(Long id);
    
    void delete(Long id);

	public List<PoreskeGrupe> getAllPoreskeGrupe();

}
