package com.hellokoding.auth.repository;

import com.hellokoding.auth.model.Klasifikacije;


import org.springframework.data.jpa.repository.JpaRepository;

public interface KlasifikacijeRepository extends JpaRepository<Klasifikacije, Long> {
	Klasifikacije findByName(String klasifikacije);
}
