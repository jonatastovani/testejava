package com.example.testejava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testejava.model.NacionalidadesModel;
import com.example.testejava.repository.NacionalidadesRepository;

@Service
public class NacionalidadesService {
	
	@Autowired
	NacionalidadesRepository repository;
	
    public List<NacionalidadesModel> listarNacionalidades() {
        return repository.findAll();
    }

    public Optional<NacionalidadesModel> buscarNacionalidadePorId(Long id) {
        return repository.findById(id);
    }

}
