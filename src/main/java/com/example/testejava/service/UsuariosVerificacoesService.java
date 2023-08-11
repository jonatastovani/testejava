package com.example.testejava.service;

import java.util.Optional;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.testejava.exception.CustomRuntimeException;
import com.example.testejava.model.UsuariosModel;

@Service
public class UsuariosVerificacoesService extends UsuariosServices {

    /*@Autowired
    UsuariosServices usuariosService;*/
    

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

    
    
}
