package com.example.testejava.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testejava.model.UsuariosModel;
import com.example.testejava.repository.UsuariosRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosServices {
	
    @Autowired
    UsuariosRepository usuariosRepository;

    public List<UsuariosModel> listarUsuarios() {
        return usuariosRepository.findAll();
    }

    public Optional<UsuariosModel> buscarUsuarioPorId(Long id) {
        return usuariosRepository.findById(id);
    }

    public UsuariosModel novoUsuario(UsuariosModel usuario) {
        return usuariosRepository.save(usuario);
    }
}
