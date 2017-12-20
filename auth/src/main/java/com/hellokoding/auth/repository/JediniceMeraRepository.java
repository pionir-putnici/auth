package com.hellokoding.auth.repository;

import com.hellokoding.auth.model.JediniceMera;


import org.springframework.data.jpa.repository.JpaRepository;

public interface JediniceMeraRepository extends JpaRepository<JediniceMera, Long> {
	JediniceMera findByName(String jediniceMera);
}
