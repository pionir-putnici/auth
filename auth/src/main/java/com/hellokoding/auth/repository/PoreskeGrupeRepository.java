package com.hellokoding.auth.repository;

import com.hellokoding.auth.model.PoreskeGrupe;


import org.springframework.data.jpa.repository.JpaRepository;

public interface PoreskeGrupeRepository extends JpaRepository<PoreskeGrupe, Long> {
	PoreskeGrupe findByName(String poreskeGrupe);
}
