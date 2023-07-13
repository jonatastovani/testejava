package com.example.testejava.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testejava.model.PermissoesModel;
import com.example.testejava.repository.PermissoesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PermissoesServices {
	
    @Autowired
    PermissoesRepository repository;
    
    public List<PermissoesModel> listAll() {
        return repository.findAll();
    }

    public Optional<PermissoesModel> fetchPermissaoById(Long id) {
        return repository.findById(id);
    }

    public PermissoesModel newUser(PermissoesModel user) {
        return repository.save(user);
    }
}
