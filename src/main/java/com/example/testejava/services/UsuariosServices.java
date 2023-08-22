package com.example.testejava.services;
import java.time.LocalDateTime;
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

    public UsuariosModel buscarUsuariosPorId(Long id) {
        return usuariosRepository.findById(id).orElseThrow(
        		() -> new EntityNotFoundException("O usuário de cadastro com ID '"+ id + "' não existe.") );
    }

    public UsuariosModel novoUsuario(UsuariosModel usuario) {
    	
    	@SuppressWarnings("unused")
		final UsuariosModel usuarioIdConferencia = verificaCadastroId(usuario.getCadastroId());
    	
    	@SuppressWarnings("unused")
		final Boolean nomeUsuarioConferencia = verificaUsuarioDuplicado(usuario.getUsuario(), null);

    	@SuppressWarnings("unused")
		final Boolean rsUsuarioConferencia = verificaRsUsuarioDuplicado(usuario.getRsUsuario(), null);

    	@SuppressWarnings("unused")
		final Boolean idPessoaConferencia = verificaIdPessoaDuplicado(usuario.getIdPessoa(), null);

    	return usuariosRepository.save(usuario);
    }
    
    public UsuariosModel alterarCompletoUsuario (Long id, UsuariosModel usuario) {
    	UsuariosModel usuarioExistente = buscarUsuariosPorId(id);
    	    	
    	@SuppressWarnings("unused")
		final UsuariosModel usuarioIdConferencia = verificaCadastroId(usuario.getAtualizacaoId());
    	
    	@SuppressWarnings("unused")
		final Boolean nomeUsuarioConferencia = verificaUsuarioDuplicado(usuario.getUsuario(), id);

    	@SuppressWarnings("unused")
		final Boolean rsUsuarioConferencia = verificaRsUsuarioDuplicado(usuario.getRsUsuario(), id);

    	@SuppressWarnings("unused")
		final Boolean idPessoaConferencia = verificaIdPessoaDuplicado(usuario.getIdPessoa(), id);
//
//    	if (usuario.getUsuario()!=usuarioExistente.getUsuario()) {
//    		usuarioExistente.setRsUsuario(usuario.getRsUsuario());
//    	}
//    	if (usuario.getStatus()!=usuarioExistente.getStatus()) {
//    		usuarioExistente.setStatus(usuario.getStatus());
//    	}
//    	if (usuario.getRsUsuario()!=usuarioExistente.getRsUsuario()) {
//    		usuarioExistente.setRsUsuario(usuario.getRsUsuario());
//    	}
//    	if (usuario.getIdPessoa()!=usuarioExistente.getIdPessoa()) {
//    		usuarioExistente.setIdPessoa(usuario.getIdPessoa());
//    	}
//    	if (usuario.getApelido()!=usuarioExistente.getApelido()) {
//    		usuarioExistente.setApelido(usuario.getApelido());
//    	}
//    	if (usuario.getIdExibicao()!=usuarioExistente.getIdExibicao()) {
//    		usuarioExistente.setIdExibicao(usuario.getIdExibicao());
//    	}
//    	if (usuario.getSenha()!=usuarioExistente.getSenha()) {
//    		usuarioExistente.setSenha(usuario.getSenha());
//    	}
//    	if (usuario.getIdTurno()!=usuarioExistente.getIdTurno()) {
//    		usuarioExistente.setIdTurno(usuario.getIdTurno());
//    	}
//    	if (usuario.getIdEscala()!=usuarioExistente.getIdEscala()) {
//    		usuarioExistente.setIdEscala(usuario.getIdEscala());
//    	}
//    	if (usuario.getContaBloqueada()!=usuarioExistente.getContaBloqueada()) {
//    		usuarioExistente.setContaBloqueada(usuario.getContaBloqueada());
//    	}
//    	if (usuario.getDataContaBloqueada()!=usuarioExistente.getDataContaBloqueada()) {
//    		usuarioExistente.setDataContaBloqueada(usuario.getDataContaBloqueada());
//    	}
    	if (usuario.getAtualizacaoData()==null) {
    		usuario.setAtualizacaoData(LocalDateTime.now());
    	}
    	
    	usuario.setId(usuarioExistente.getId());
    	usuario.setCadastroId(usuarioExistente.getCadastroId());
    	usuario.setCadastroIp(usuarioExistente.getCadastroIp());
    	usuario.setCadastroData(usuarioExistente.getCadastroData());

    	return usuariosRepository.save(usuario);
    };

    public UsuariosModel verificaCadastroId (Long usuarioId) {
    	if (usuarioId==null || usuarioId<1) {
    		throw new IDNotFoundException("ID do usuário que está cadastrando os dados não foi informado. Efetue o login novamente.");
    	}
    	
        UsuariosModel register = buscarUsuariosPorId(usuarioId);

        return register;
    }
    
    public Boolean verificaUsuarioDuplicado (String usuario, Long idExistente) {
    	if (usuario==null || usuario.isEmpty()) {
    		throw new IDNotFoundException("O Nome de Usuário não foi informado.");
		}

        Optional<UsuariosModel> pessoaExistente = usuariosRepository.findByUsuario(usuario);
        if (pessoaExistente.isPresent()) {
        	if (idExistente==null || idExistente!=null && idExistente!=pessoaExistente.get().getId()) {
            	throw new DuplicatedRegisterException("O Nome de Usuário '" + usuario + "' já existe cadastrado.");
        	}
        }
        return pessoaExistente.isPresent();
    }
    
    public Boolean verificaRsUsuarioDuplicado (Long rsUsuario, Long idExistente) {
    	if (rsUsuario==null) {
    		throw new IDNotFoundException("O RS do Usuário não foi informado.");
    	}

        Optional<UsuariosModel> pessoaExistente = usuariosRepository.findByRsUsuario(rsUsuario);
        if (pessoaExistente.isPresent()) {
        	if (idExistente==null || idExistente!=null && idExistente!=pessoaExistente.get().getId()) {
        		throw new DuplicatedRegisterException("O RS de Usuário '" + rsUsuario + "' já existe cadastrado.");
        	}
        }
        return pessoaExistente.isPresent();
    }
    
    public Boolean verificaIdPessoaDuplicado (Long idPessoa, Long idExistente) {
    	if (idPessoa==null) {
    		throw new IDNotFoundException("O ID Pessoa do Usuário não foi informado.");
    	}

        Optional<UsuariosModel> pessoaExistente = usuariosRepository.findByIdPessoa(idPessoa);
        if (pessoaExistente.isPresent()) {
        	if (idExistente==null || idExistente!=null && idExistente!=pessoaExistente.get().getId()) {
        		throw new DuplicatedRegisterException("O ID Pessoa '" + idPessoa + "' já existe vinculado a outro Usuário. "
        			+ "Usuário: " + pessoaExistente.get().getUsuario());
        	}
        }
        return pessoaExistente.isPresent();
    }
    
}
