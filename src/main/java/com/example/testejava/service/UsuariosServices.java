package com.example.testejava.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.testejava.exception.CustomRuntimeException;
import com.example.testejava.model.PessoaCadastroModel;
import com.example.testejava.model.UsuariosModel;
import com.example.testejava.repository.UsuariosRepository;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosServices {
	
    @Autowired
    UsuariosRepository usuariosRepository;

    @Autowired
    PessoaCadastroServices pessoaCadastroServices;
    
    public List<UsuariosModel> listarUsuarios() {
        return usuariosRepository.findAll();
    }

    public Optional<UsuariosModel> buscarUsuarioPorId(Long id) {
        return usuariosRepository.findById(id);
    }

    public UsuariosModel novoUsuario(UsuariosModel usuario) {
    	
    	@SuppressWarnings("unused")
		final Optional<UsuariosModel> usuarioIdConferencia = verificaIdCadastroInformado(usuario.getCadastroId());
    	
    	@SuppressWarnings("unused")
		final Boolean nomeUsuarioConferencia = verificaNomeUsuarioExistente(usuario.getUsuario());
    	
    	@SuppressWarnings("unused")
    	final Optional<PessoaCadastroModel> pessoaIdConferencia = verificaIdPessoaInformado(usuario.getIdPessoa());
    	

    	
    	
        return usuariosRepository.save(usuario);
    }
    
    public Optional<UsuariosModel> verificaIdCadastroInformado (Long usuarioId) {
    	if (usuarioId==null || usuarioId<1) {
            throw new CustomRuntimeException("ID_CADASTRO_NÃO_INFORMADO", "O ID do usuário de cadastro não foi informado", HttpStatus.BAD_REQUEST);
    	}
    	
        Optional<UsuariosModel> cadastro = buscarUsuarioPorId(usuarioId);

        if (!cadastro.isPresent()) {
            throw new CustomRuntimeException("ID_CADASTRO_INEXISTENTE", "O usuário de cadastro não existe", HttpStatus.NOT_FOUND);
        }
        
        return cadastro;
    }
    
    public Boolean verificaNomeUsuarioExistente (String usuario) {
    	if (usuario==null || usuario.isEmpty()) {
            throw new CustomRuntimeException("NOME_USUARIO_NÃO_INFORMADO", "O nome de usuário não foi informado.", HttpStatus.BAD_REQUEST);
    	}

        Optional<UsuariosModel> usuarioExistente = usuariosRepository.findByUsuario(usuario);
        if (usuarioExistente.isPresent()) {
            throw new CustomRuntimeException("NOME_USUARIO_DUPLICADO", "O nome de usuário informado já existe cadastrado.", HttpStatus.CONFLICT);
        }
        return usuarioExistente.isPresent();
    }
    

    public Optional<PessoaCadastroModel> verificaIdPessoaInformado (Long pessoaId) {
    	if (pessoaId==null || pessoaId<1) {
            throw new CustomRuntimeException("ID_PESSOA_NÃO_INFORMADO", "O ID Pessoa não foi informado", HttpStatus.BAD_REQUEST);
    	}
    	
        Optional<PessoaCadastroModel> pessoa = pessoaCadastroServices.buscarPessoaPorId(pessoaId);

        if (!pessoa.isPresent()) {
            throw new CustomRuntimeException("ID_PESSOA_INEXISTENTE", "O ID Pessoa informado não existe", HttpStatus.NOT_FOUND);
        }
        
        return pessoa;
    }
}
