package com.hellokoding.auth.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.hellokoding.auth.model.Magacini;

@Transactional
@Repository
public interface MagaciniDao extends CrudRepository<Magacini, Long>{

	public List<Magacini> findAll();
	
	public Magacini findById(Long id);

}
