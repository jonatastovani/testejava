package com.example.testejava.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.testejava.model.PessoaCadastroModel;

@Repository
public interface PessoaCadastroRepository extends JpaRepository<PessoaCadastroModel, Long>{

	Optional<PessoaCadastroModel> findByCpf(String cpf);

	List<PessoaCadastroModel> findByRg(String rg);

}
