package com.hellokoding.auth.repository;

import com.hellokoding.auth.model.VrstePaleta;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VrstePaletaRepository extends JpaRepository<VrstePaleta, Long> {
    VrstePaleta findByName(String vrstePaleta);
}
