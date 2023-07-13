package com.example.testejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.testejava.model.PermissoesModel;

@Repository
public interface PermissoesRepository extends JpaRepository<PermissoesModel, Long>{

}
