package com.example.testejava.resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.testejava.model.PessoaCadastroModel;
import com.example.testejava.service.PessoaCadastroServices;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
public class PessoaCadastroController {
    @Autowired
    PessoaCadastroServices service;

    @GetMapping
    public List<PessoaCadastroModel> listAll() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaCadastroModel> fetchPessoaById(@PathVariable Long id) {
        Optional<PessoaCadastroModel> pessoa = service.fetchPessoaById(id);

        if (pessoa.isPresent()) {
            return ResponseEntity.ok(pessoa.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<PessoaCadastroModel> newUser(@RequestBody PessoaCadastroModel user) {
    	PessoaCadastroModel newUser = service.newUser(user);
        return ResponseEntity.ok(newUser);
    }
}
