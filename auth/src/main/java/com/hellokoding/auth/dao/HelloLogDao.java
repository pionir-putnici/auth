package com.hellokoding.auth.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hellokoding.auth.model.HelloLog;

@Transactional
@Repository
public interface HelloLogDao extends CrudRepository<HelloLog, Integer>{

	public List<HelloLog> findAll();
	
	public HelloLog findByUid(Integer uid);
	
//	public List<HelloLog> findByName(String name);
}
