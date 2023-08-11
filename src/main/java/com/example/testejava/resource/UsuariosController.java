package com.example.testejava.resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.testejava.exception.CustomRuntimeException;
import com.example.testejava.model.UsuariosModel;
import com.example.testejava.service.UsuariosServices;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

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
        Optional<UsuariosModel> user = usuariosServices.buscarUsuarioPorId(id);

        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Object> newUser(@Valid @RequestBody UsuariosModel user) {
    	try {
    		usuariosServices.novoUsuario(user);
    		return ResponseEntity.ok().build();
        } catch (CustomRuntimeException ex) {
        	CustomRuntimeException errorResponse = new CustomRuntimeException(ex.getErrorCode(), ex.getMessage(), ex.getHttpStatus());
            return ResponseEntity.status(ex.getHttpStatus()).body(errorResponse);
        }
    }
}
