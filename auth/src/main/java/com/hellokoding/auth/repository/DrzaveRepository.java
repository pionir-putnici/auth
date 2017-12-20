package com.hellokoding.auth.repository;
import com.hellokoding.auth.model.Drzave;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DrzaveRepository extends JpaRepository<Drzave, Long> {
	Drzave findByName(String drzave);
	List<Drzave> findAllByOrderByIdDesc();
}
