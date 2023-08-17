package com.example.testejava.resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.testejava.model.PermissoesModel;
import com.example.testejava.services.PermissoesServices;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/permissoes")
public class PermissoesController {
    @Autowired
    PermissoesServices service;

    @GetMapping
    public List<PermissoesModel> listAll() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PermissoesModel> fetchPessoaById(@PathVariable Long id) {
        Optional<PermissoesModel> pessoa = service.fetchPermissaoById(id);

        if (pessoa.isPresent()) {
            return ResponseEntity.ok(pessoa.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<PermissoesModel> newUser(@RequestBody PermissoesModel user) {
    	PermissoesModel newUser = service.newUser(user);
        return ResponseEntity.ok(newUser);
    }
}
