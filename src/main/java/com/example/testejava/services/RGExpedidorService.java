package com.example.testejava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testejava.model.RGExpedidorModel;
import com.example.testejava.repository.RGExpedidorRepository;
import com.example.testejava.services.exceptions.EntityNotFoundException;

@Service
public class RGExpedidorService {
	
	@Autowired
	RGExpedidorRepository repository;
	
    public List<RGExpedidorModel> listarRGExpedidores() {
        return repository.findAll();
    }

    public RGExpedidorModel buscarRGExpedidorPorId(Long id) {
        return repository.findById(id).orElseThrow(
        		() -> new EntityNotFoundException("O Expedidor de RG com ID '"+ id + "' não existe.") );
    }

}
