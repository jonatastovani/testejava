package com.example.testejava.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.testejava.model.UsuarioModel;


@Repository
public interface UsuarioRepositorio extends JpaRepository <UsuarioModel, Long> {
		

}
