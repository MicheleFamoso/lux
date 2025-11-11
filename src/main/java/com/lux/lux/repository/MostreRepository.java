package com.lux.lux.repository;

import com.lux.lux.model.Mostre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MostreRepository extends JpaRepository<Mostre,Integer> {


    List<Mostre> findAllByOrderByIdDesc();
}
