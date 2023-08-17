package com.example.testejava.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testejava.model.UsuariosModel;
import com.example.testejava.repository.UsuariosRepository;
import com.example.testejava.services.exceptions.DuplicatedRegisterException;
import com.example.testejava.services.exceptions.EntityNotFoundException;
import com.example.testejava.services.exceptions.IDNotFoundException;

@Service
public class UsuariosServices {
	
    @Autowired
    UsuariosRepository usuariosRepository;
        
    public List<UsuariosModel> listarUsuarios() {
        return usuariosRepository.findAll();
    }

    public UsuariosModel findById(Long id) {
        return usuariosRepository.findById(id).orElseThrow(
        		() -> new EntityNotFoundException("O usuário de cadastro com ID "+ id + " não existe.") );
    }

    public UsuariosModel newUser(UsuariosModel usuario) {
    	
    	@SuppressWarnings("unused")
		final UsuariosModel usuarioIdConferencia = checkInformedIdCadastro(usuario.getCadastroId());
    	
    	@SuppressWarnings("unused")
		final Boolean nomeUsuarioConferencia = verificaNomeUsuarioExistente(usuario.getUsuario());

        return usuariosRepository.save(usuario);
    }
    
    public UsuariosModel checkInformedIdCadastro (Long usuarioId) {
    	if (usuarioId==null || usuarioId<1) {
            new IDNotFoundException("ID do usuário de cadastro não foi informado");
    	}
    	
        UsuariosModel cadastro = findById(usuarioId);

        return cadastro;
    }
    
    public Boolean verificaNomeUsuarioExistente (String usuario) {
    	if (usuario==null || usuario.isEmpty()) {
            new IDNotFoundException("O nome de usuário não foi informado.");
    	}

        Optional<UsuariosModel> usuarioExistente = usuariosRepository.findByUsuario(usuario);
        if (usuarioExistente.isPresent()) {
            new DuplicatedRegisterException("O nome de usuário informado já existe cadastrado.");
        }
        return usuarioExistente.isPresent();
    }
}
