package com.example.testejava.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testejava.model.UsuarioModel;
import com.example.testejava.model.repository.UsuarioRepositorio;

@RestController
@RequestMapping("/usuarios")
public class UsuarioRest {
    @Autowired
    UsuarioRepositorio repositorio;
    
    @GetMapping("{id}")
        public Optional<UsuarioModel> buscarUsuarioPeloId(@PathVariable Long id){
        // Lógica para processar a requisição e obter os dados
        Optional<UsuarioModel> usuario = repositorio.findById(id);
        return usuario;
    }
   repositorio.save(usuario);
}
