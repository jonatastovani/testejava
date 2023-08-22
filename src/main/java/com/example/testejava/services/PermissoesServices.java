package com.example.testejava.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testejava.model.PermissoesModel;
import com.example.testejava.repository.PermissoesRepository;
import com.example.testejava.services.exceptions.EntityNotFoundException;

@Service
public class PermissoesServices {
	
    @Autowired
    PermissoesRepository repository;
    
    public List<PermissoesModel> listAll() {
        return repository.findAll();
    }

    public PermissoesModel buscarPermissaoPorId(Long id) {
        return repository.findById(id).orElseThrow(
        		() -> new EntityNotFoundException("A Permissão com ID '"+ id + "' não existe.") );
    }

}
