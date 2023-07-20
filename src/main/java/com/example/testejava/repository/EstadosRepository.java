package com.example.testejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.testejava.model.EstadosModel;

@Repository
public interface EstadosRepository extends JpaRepository<EstadosModel, Long>{

}
