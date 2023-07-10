package com.example.testejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.testejava.model.UsuariosModel;


@Repository
public interface UsuariosRepository extends JpaRepository <UsuariosModel, Long> {
		

}
