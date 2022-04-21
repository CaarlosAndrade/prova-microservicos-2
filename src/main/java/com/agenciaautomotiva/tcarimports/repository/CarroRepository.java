package com.agenciaautomotiva.tcarimports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agenciaautomotiva.tcarimports.model.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long>{

}
