package com.example.testejava.resources;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testejava.model.PermissoesModel;
import com.example.testejava.services.PermissoesServices;

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
    public ResponseEntity<PermissoesModel> buscarPermissaoPorId(@PathVariable Long id) {
        PermissoesModel pessoa = service.buscarPermissaoPorId(id);
        return ResponseEntity.ok().body(pessoa);
    }
}
