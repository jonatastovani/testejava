package com.example.testejava.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testejava.model.CidadesModel;
import com.example.testejava.repository.CidadesRepository;

@Service
public class CidadesService {
	
	@Autowired
	CidadesRepository repository;
	
    public List<CidadesModel> listarCidades() {
        return repository.findAll();
    }

    public Optional<CidadesModel> buscarCidadePorId(Long id) {
        return repository.findById(id);
    }

}
