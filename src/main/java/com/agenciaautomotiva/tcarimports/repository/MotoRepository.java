package com.agenciaautomotiva.tcarimports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.agenciaautomotiva.tcarimports.model.Moto;

@Repository
public interface MotoRepository extends JpaRepository<Moto, Long>{

}
