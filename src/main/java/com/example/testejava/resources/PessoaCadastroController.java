package com.example.testejava.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testejava.model.PessoaCadastroModel;
import com.example.testejava.services.PessoaCadastroServices;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaCadastroController {

    @Autowired
    PessoaCadastroServices pessoaService;

    @GetMapping
    public List<PessoaCadastroModel> findAll() {
        return pessoaService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
    	PessoaCadastroModel pessoa = pessoaService.findById(id);
        return ResponseEntity.ok().body(pessoa);
    }

    /*@PostMapping("/cadastrar")
    public ResponseEntity<Object> novaPessoa(@RequestBody PessoaCadastroModel user) {
        try {
            pessoaService.novaPessoa(user);
            return ResponseEntity.ok().build();
        } catch (CustomRuntimeException ex) {
        	CustomRuntimeException errorResponse = new CustomRuntimeException(ex.getErrorCode(), ex.getMessage(), ex.getHttpStatus());
            return ResponseEntity.status(ex.getHttpStatus()).body(errorResponse);
        }
    }*/
}
