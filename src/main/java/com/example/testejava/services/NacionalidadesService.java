package com.example.testejava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testejava.model.NacionalidadesModel;
import com.example.testejava.repository.NacionalidadesRepository;
import com.example.testejava.services.exceptions.EntityNotFoundException;

@Service
public class NacionalidadesService {
	
	@Autowired
	NacionalidadesRepository repository;
	
    public List<NacionalidadesModel> listarNacionalidades() {
        return repository.findAll();
    }

    public NacionalidadesModel buscarNacionalidadePorId(Long id) {
        return repository.findById(id).orElseThrow(
        		() -> new EntityNotFoundException("A Nacionalidade com ID '"+ id + "' não existe.") );
    }

}
