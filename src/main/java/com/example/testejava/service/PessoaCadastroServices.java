package com.example.testejava.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testejava.model.PessoaCadastroModel;
import com.example.testejava.model.UsuariosModel;
import com.example.testejava.repository.PessoaCadastroRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaCadastroServices {
	
    @Autowired
    PessoaCadastroRepository repository;
    @Autowired
    UsuariosServices repositoryUsuarios;
    
    public List<PessoaCadastroModel> buscarTodasPessoas() {
        return repository.findAll();
    }

    public Optional<PessoaCadastroModel> buscarPessoaPorId(Long id) {
        return repository.findById(id);
    }

    public PessoaCadastroModel novaPessoa(PessoaCadastroModel novaPessoa) {
        try {
        	Long cadastroId = novaPessoa.getCadastroId();
        	
        	if (cadastroId != null) {
        		Optional<UsuariosModel> cadastro = repositoryUsuarios.buscarUsuarioPorId(cadastroId);
        		
        		if (cadastro.isPresent()) {
        			novaPessoa.setCadastro(cadastro.get());
        			
                    return repository.save(novaPessoa);
        		} else {
                    throw new RuntimeException("O usuário de cadastro não existe");
                }
        		
        	} else {
                throw new RuntimeException("O ID do usuário de cadastro não foi informado");
            }
        	
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Ocorreu um erro ao cadastrar a nova pessoa");
        }
    }
}
