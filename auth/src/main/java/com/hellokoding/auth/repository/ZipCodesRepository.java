package com.hellokoding.auth.repository;
import com.hellokoding.auth.model.PttBrojevi;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ZipCodesRepository extends JpaRepository<PttBrojevi, Long> {
	PttBrojevi findByName(String pttBrojevi);
	List<PttBrojevi> findAllByOrderByIdDesc();
}
