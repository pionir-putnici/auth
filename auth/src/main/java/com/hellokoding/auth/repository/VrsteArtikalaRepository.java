package com.hellokoding.auth.repository;

import com.hellokoding.auth.model.VrsteArtikala;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VrsteArtikalaRepository extends JpaRepository<VrsteArtikala, Long> {
	VrsteArtikala findByName(String vrstePaleta);
}
