package com.example.testejava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testejava.model.CidadesModel;
import com.example.testejava.repository.CidadesRepository;
import com.example.testejava.services.exceptions.EntityNotFoundException;

@Service
public class CidadesService {
	
	@Autowired
	CidadesRepository repository;
	
    public List<CidadesModel> listarCidades() {
        return repository.findAll();
    }

    public CidadesModel buscarCidadePorId(Long id) {
        return repository.findById(id).orElseThrow(
        		() -> new EntityNotFoundException("A Cidade com ID '"+ id + "' não existe.") );
    }

}
