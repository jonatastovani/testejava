package com.example.testejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.testejava.model.PessoaCadastroModel;

@Repository
public interface PessoaCadastroRepository extends JpaRepository<PessoaCadastroModel, Long>{

}
