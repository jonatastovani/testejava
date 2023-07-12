package com.example.testejava.resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.testejava.model.UsuariosModel;
import com.example.testejava.service.UsuariosServices;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    @Autowired
    UsuariosServices usuariosServices;

    @GetMapping
    public List<UsuariosModel> listUsers() {
        return usuariosServices.listUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuariosModel> fetchUserById(@PathVariable Long id) {
        Optional<UsuariosModel> user = usuariosServices.fetchUserById(id);

        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<UsuariosModel> newUser(@RequestBody UsuariosModel user) {
        UsuariosModel newUser = usuariosServices.newUser(user);
        return ResponseEntity.ok(newUser);
    }
}
