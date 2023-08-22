package com.example.testejava.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testejava.model.EstadosModel;
import com.example.testejava.model.PessoaCadastroModel;
import com.example.testejava.model.UsuariosModel;
import com.example.testejava.repository.PessoaCadastroRepository;
import com.example.testejava.services.exceptions.DuplicatedRegisterException;
import com.example.testejava.services.exceptions.EntityNotFoundException;
import com.example.testejava.services.exceptions.IDNotFoundException;

@Service
public class PessoaCadastroServices {

    @Autowired
    PessoaCadastroRepository pessoaRepository;
    
    @Autowired
    RGExpedidorService rgExpedidorService;
    @Autowired
    EstadosService estadosService;
    @Autowired
    CidadesService cidadesService;
    @Autowired
    NacionalidadesService nacionalidadesService;
    @Autowired
    UsuariosServices usuariosServices;
    
    public List<PessoaCadastroModel> listarPessoas() {
        return pessoaRepository.findAll();
    }

    public PessoaCadastroModel buscarPessoaPorId(Long id) {
        return pessoaRepository.findById(id).orElseThrow(
        		() -> new EntityNotFoundException("ID não encontrado " + id) );
    }

    public Optional<PessoaCadastroModel> findByCpf(String cpf) {
        return pessoaRepository.findByCpf(cpf);
    }

    public List<PessoaCadastroModel> findByRg(String rg) {
        return pessoaRepository.findByRg(rg);
    }

    public PessoaCadastroModel novaPessoa(PessoaCadastroModel novaPessoa) {
   	
        @SuppressWarnings("unused")
		final Boolean cpfExistente = verificaCpfDuplicado(novaPessoa.getCpf(), null);
        
		final UsuariosModel confereCadastroId = usuariosServices.verificaCadastroId(novaPessoa.getCadastroId());

        novaPessoa.setCadastro(confereCadastroId);

        return pessoaRepository.save(novaPessoa);
    }
    
    public PessoaCadastroModel alterarCompletoPessoa (Long id, PessoaCadastroModel pessoa) {
       	PessoaCadastroModel pessoaExistente = buscarPessoaPorId(id);
    	
    	@SuppressWarnings("unused")
       	final Boolean verificaRgDuplicado = verificaRgMesmoEstadoDuplicado(pessoa,id);
       	
    	@SuppressWarnings("unused")
    	final UsuariosModel confereCadastroId = usuariosServices.verificaCadastroId(pessoa.getAtualizacaoId());

        @SuppressWarnings("unused")
		final Boolean cpfExistente = verificaCpfDuplicado(pessoa.getCpf(), id);
        
    	if (pessoa.getAtualizacaoData()==null) {
    		pessoa.setAtualizacaoData(LocalDateTime.now());
    	}
    	
    	pessoa.setId(pessoaExistente.getId());
    	pessoa.setCadastroId(pessoaExistente.getCadastroId());
    	pessoa.setCadastroIp(pessoaExistente.getCadastroIp());
    	pessoa.setCadastroData(pessoaExistente.getCadastroData());
        
        return pessoaRepository.save(pessoa);
    }
    
    public PessoaCadastroModel setCompletoPropriedadesPessoa(PessoaCadastroModel pessoa) {
    	if (pessoa.getRgIdEstado()!=null) {
    		pessoa.setRgEstado(estadosService.buscarEstadoPorId(pessoa.getRgIdEstado()));
    	}
		
    	Colocar o restante aqui
    	
    	
    	return pessoa;
	}
    
    public Boolean verificaCpfDuplicado(String cpf, Long idExistente) {
    	if (cpf==null || cpf.isEmpty()) {
            throw new IDNotFoundException("O CPF não foi informado.");
    	}

        Optional<PessoaCadastroModel> pessoaExistente = findByCpf(cpf);
        if (pessoaExistente.isPresent()) {
        	if (idExistente==null || idExistente!=null && idExistente!=pessoaExistente.get().getId()) {
            	throw new DuplicatedRegisterException("O CPF informado já existe cadastrado.");
        	}
        } 
        return pessoaExistente.isPresent();
    }

    public Boolean verificaRgMesmoEstadoDuplicado(PessoaCadastroModel pessoaVerificar, Long idExistente) {
    	if (idExistente==null && pessoaVerificar.getId()!=null) {
    		idExistente = pessoaVerificar.getId();
    	}
    	
    	String rg = pessoaVerificar.getRg();

    	if (rg!=null && !rg.isEmpty()) {
    		
    		List<PessoaCadastroModel> pessoasComRg = findByRg(rg);
	        if (pessoasComRg.size()>0) {
	        	
	        	@SuppressWarnings("unused")
				PessoaCadastroModel pessoaExistente = new PessoaCadastroModel();
	        	
	        	if (idExistente!=null) {
	        		pessoaExistente = buscarPessoaPorId(idExistente);
	        	}
	        	
	        	for (PessoaCadastroModel pessoa : pessoasComRg) {
	        		if (idExistente==null || idExistente!=pessoa.getId()) {
	        			
	        			if (pessoa.getRg().equals(pessoaVerificar.getRg())) {
	        				EstadosModel getRgEstado = pessoa.getRgEstado();
	        				if (getRgEstado.getId().equals(pessoaVerificar.getRgIdEstado())) {
				            	throw new DuplicatedRegisterException("O RG " + pessoa.getRg() + " já encontra-se cadastrado para o Estado Selecionado. ");
	        				}
	        			}
	        		}
				}	        	
	        }   		
    	}

        return true;
    }

    public PessoaCadastroModel verificaIdPessoa (Long idPessoa) {
    	if (idPessoa==null || idPessoa<1) {
            new IDNotFoundException("O ID Pessoa não foi informado");
    	}
    	
        PessoaCadastroModel pessoa = buscarPessoaPorId(idPessoa);
        return pessoa;
    }

}
