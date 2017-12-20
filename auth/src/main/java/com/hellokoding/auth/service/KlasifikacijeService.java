package com.hellokoding.auth.service;

import java.util.List;

import com.hellokoding.auth.model.Klasifikacije;


public interface KlasifikacijeService {
			
    void save(Klasifikacije klasifikacije);

    Klasifikacije findByName(String username);
    
    Klasifikacije findByOne(Long id);
    
    void delete(Long id);

	public List<Klasifikacije> getAllKlasifikacije();



	List<Klasifikacije> getAllKlasifikacijeOrderByCode();

}
