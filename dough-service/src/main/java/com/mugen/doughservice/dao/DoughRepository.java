package com.mugen.doughservice.dao;

import com.mugen.doughservice.model.Dough;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoughRepository extends JpaRepository<Dough, Long> {

}
