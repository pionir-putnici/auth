package com.hellokoding.auth.repository;
import com.hellokoding.auth.model.Partner;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CostumersRepository extends JpaRepository<Partner, Long> {
	Partner findByName(String customeri);
	List<Partner> findAllByOrderByIdDesc();
}
