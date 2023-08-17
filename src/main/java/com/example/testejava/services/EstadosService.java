package com.example.testejava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testejava.model.EstadosModel;
import com.example.testejava.repository.EstadosRepository;

@Service
public class EstadosService {
	
	@Autowired
	EstadosRepository repository;
	
    public List<EstadosModel> listarEstados() {
        return repository.findAll();
    }

    public Optional<EstadosModel> buscarEstadoPorId(Long id) {
        return repository.findById(id);
    }

}
