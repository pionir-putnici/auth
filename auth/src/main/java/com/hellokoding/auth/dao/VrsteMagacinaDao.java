package com.hellokoding.auth.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.hellokoding.auth.model.VrsteMagacina;

@Transactional
@Repository
public interface VrsteMagacinaDao extends CrudRepository<VrsteMagacina, Long>{

	public List<VrsteMagacina> findAll();
	
	public VrsteMagacina findById(Long id);

}
