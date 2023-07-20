package com.example.testejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.testejava.model.NacionalidadesModel;

@Repository
public interface NacionalidadesRepository extends JpaRepository<NacionalidadesModel, Long>{

}
