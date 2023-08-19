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
        		() -> new EntityNotFoundException("O usuário de cadastro com ID '"+ id + "' não existe.") );
    }

    public UsuariosModel novoUsuario(UsuariosModel usuario) {
    	
    	@SuppressWarnings("unused")
		final UsuariosModel usuarioIdConferencia = checkInformedCadastroId(usuario.getCadastroId());
    	
    	@SuppressWarnings("unused")
		final Boolean nomeUsuarioConferencia = checkInformedDuplicatedUsuario(usuario.getUsuario(), null);

    	@SuppressWarnings("unused")
		final Boolean rsUsuarioConferencia = checkInformedDuplicatedRsUsuario(usuario.getRsUsuario(), null);

    	@SuppressWarnings("unused")
		final Boolean idPessoaConferencia = checkInformedDuplicatedIdPessoa(usuario.getIdPessoa(), null);

    	return usuariosRepository.save(usuario);
    }
    
    public UsuariosModel alterarUsuario (Long id, UsuariosModel usuario) {
    	UsuariosModel usuarioExistente = findById(id);
    	
    	usuario.setId(id);
    	
    	@SuppressWarnings("unused")
		final Boolean nomeUsuarioConferencia = checkInformedDuplicatedUsuario(usuario.getUsuario(), id);

    	@SuppressWarnings("unused")
		final Boolean rsUsuarioConferencia = checkInformedDuplicatedRsUsuario(usuario.getRsUsuario(), id);

    	@SuppressWarnings("unused")
		final Boolean idPessoaConferencia = checkInformedDuplicatedIdPessoa(usuario.getIdPessoa(), id);

    	
    	//Tem que alterar sem mudar os registros que não foram enviados
    	
    	return usuariosRepository.save(usuarioExistente);
    };
    
    public UsuariosModel checkInformedCadastroId (Long usuarioId) {
    	if (usuarioId==null || usuarioId<1) {
    		throw new IDNotFoundException("ID do usuário de cadastro não foi informado");
    	}
    	
        UsuariosModel register = findById(usuarioId);

        return register;
    }
    
    public Boolean checkInformedDuplicatedUsuario (String usuario, Long idExistente) {
    	if (usuario==null || usuario.isEmpty()) {
    		throw new IDNotFoundException("O Nome de Usuário não foi informado.");
		}

        Optional<UsuariosModel> existingUser = usuariosRepository.findByUsuario(usuario);
        if (existingUser.isPresent()) {
        	if (idExistente==null || idExistente!=null && idExistente!=existingUser.get().getId()) {
            	throw new DuplicatedRegisterException("O Nome de Usuário '" + usuario + "' já existe cadastrado.");
        	}
        }
        return existingUser.isPresent();
    }
    
    public Boolean checkInformedDuplicatedRsUsuario (Long rsUsuario, Long idExistente) {
    	if (rsUsuario==null) {
    		throw new IDNotFoundException("O RS do Usuário não foi informado.");
    	}

        Optional<UsuariosModel> existingUser = usuariosRepository.findByRsUsuario(rsUsuario);
        if (existingUser.isPresent()) {
        	if (idExistente==null || idExistente!=null && idExistente!=existingUser.get().getId()) {
        		throw new DuplicatedRegisterException("O RS de Usuário '" + rsUsuario + "' já existe cadastrado.");
        	}
        }
        return existingUser.isPresent();
    }
    
    public Boolean checkInformedDuplicatedIdPessoa (Long idPessoa, Long idExistente) {
    	if (idPessoa==null) {
    		throw new IDNotFoundException("O ID Pessoa do Usuário não foi informado.");
    	}

        Optional<UsuariosModel> existingUser = usuariosRepository.findByIdPessoa(idPessoa);
        if (existingUser.isPresent()) {
        	if (idExistente==null || idExistente!=null && idExistente!=existingUser.get().getId()) {
        		throw new DuplicatedRegisterException("O ID Pessoa '" + idPessoa + "' já existe vinculado a outro Usuário. "
        			+ "Usuário: " + existingUser.get().getUsuario());
        	}
        }
        return existingUser.isPresent();
    }
    
}
