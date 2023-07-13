package com.example.testejava.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testejava.model.PessoaCadastroModel;
import com.example.testejava.repository.PessoaCadastroRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaCadastroServices {
	
    @Autowired
    PessoaCadastroRepository repository;
    
    public List<PessoaCadastroModel> listAll() {
        return repository.findAll();
    }

    public Optional<PessoaCadastroModel> fetchPessoaById(Long id) {
        return repository.findById(id);
    }

    public PessoaCadastroModel newUser(PessoaCadastroModel user) {
        return repository.save(user);
    }
}
