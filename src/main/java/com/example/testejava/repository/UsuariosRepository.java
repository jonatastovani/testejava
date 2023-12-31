package com.example.testejava.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.testejava.model.UsuariosModel;

@Repository
public interface UsuariosRepository extends JpaRepository <UsuariosModel, Long> {

	Optional<UsuariosModel> findByUsuario(String usuario);
		
	Optional<UsuariosModel> findByRsUsuario(Long rsUsuario);
	
	Optional<UsuariosModel> findByIdPessoa(Long idPessoa);

}
