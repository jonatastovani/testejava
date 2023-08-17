package com.example.testejava.resources;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testejava.model.UsuariosModel;
import com.example.testejava.services.UsuariosServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    @Autowired
    UsuariosServices usuariosServices;

    @GetMapping
    public List<UsuariosModel> listUsers() {
        return usuariosServices.listarUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuariosModel> fetchUserById(@PathVariable Long id) {
        UsuariosModel user = usuariosServices.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Object> newUser(@Valid @RequestBody UsuariosModel user) {
		usuariosServices.newUser(user);
		return ResponseEntity.ok().body(user);
    }
}
