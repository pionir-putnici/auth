package com.hellokoding.auth.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.hellokoding.auth.model.VrstePaleta;

@Transactional
@Repository
public interface VrstePaletaDao extends CrudRepository<VrstePaleta, Long>{

	public List<VrstePaleta> findAll();
	
	public VrstePaleta findByUid(Long uid);

}
