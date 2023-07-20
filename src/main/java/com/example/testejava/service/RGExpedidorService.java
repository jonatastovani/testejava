package com.example.testejava.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testejava.model.RGExpedidorModel;
import com.example.testejava.repository.RGExpedidorRepository;

@Service
public class RGExpedidorService {
	
	@Autowired
	RGExpedidorRepository repository;
	
    public List<RGExpedidorModel> listarRGExpedidores() {
        return repository.findAll();
    }

    public Optional<RGExpedidorModel> buscarRGExpedidorPorId(Long id) {
        return repository.findById(id);
    }

}
