package com.example.testejava.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testejava.model.PessoaCadastroModel;
import com.example.testejava.services.PessoaCadastroServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaCadastroController {

    @Autowired
    PessoaCadastroServices pessoaService;

    @GetMapping
    public List<PessoaCadastroModel> findAll() {
        return pessoaService.listarPessoas();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
    	PessoaCadastroModel pessoa = pessoaService.buscarPessoaPorId(id);
        return ResponseEntity.ok().body(pessoa);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<PessoaCadastroModel> novaPessoa(@Valid @RequestBody PessoaCadastroModel pessoa) {
    	PessoaCadastroModel novaPessoa = pessoaService.novaPessoa(pessoa);
        return ResponseEntity.ok().body(novaPessoa);
    }
    
    @PutMapping("/alterar/{id}")
    public ResponseEntity<PessoaCadastroModel> alterarPessoa(@Valid @PathVariable Long id, @RequestBody PessoaCadastroModel pessoa){
    	PessoaCadastroModel alterarPessoa = pessoaService.alterarCompletoPessoa(id, pessoa);
    	return ResponseEntity.ok().body(alterarPessoa);
    }
    
}
