package com.example.testejava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testejava.model.EstadosModel;
import com.example.testejava.repository.EstadosRepository;
import com.example.testejava.services.exceptions.EntityNotFoundException;

@Service
public class EstadosService {
	
	@Autowired
	EstadosRepository repository;
	
    public List<EstadosModel> listarEstados() {
        return repository.findAll();
    }

    public EstadosModel buscarEstadoPorId(Long id) {
        return repository.findById(id).orElseThrow(
        		() -> new EntityNotFoundException("O Estado com ID '"+ id + "' não existe.") );
    }

}
