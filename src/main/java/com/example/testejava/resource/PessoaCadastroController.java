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
        return service.buscarTodasPessoas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaCadastroModel> buscarPessoaPorId(@PathVariable Long id) {
        Optional<PessoaCadastroModel> pessoa = service.buscarPessoaPorId(id);

        if (pessoa.isPresent()) {
            return ResponseEntity.ok(pessoa.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<PessoaCadastroModel> novaPessoa(@RequestBody PessoaCadastroModel user) {
    	PessoaCadastroModel novaPessoa = service.novaPessoa(user);
        return ResponseEntity.ok(novaPessoa);
    }
}
