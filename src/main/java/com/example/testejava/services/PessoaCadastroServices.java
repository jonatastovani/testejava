package com.example.testejava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testejava.model.CidadesModel;
import com.example.testejava.model.EstadosModel;
import com.example.testejava.model.NacionalidadesModel;
import com.example.testejava.model.PessoaCadastroModel;
import com.example.testejava.model.RGExpedidorModel;
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
    
    public List<PessoaCadastroModel> findAll() {
        return pessoaRepository.findAll();
    }

    public PessoaCadastroModel findById(Long id) {
        return pessoaRepository.findById(id).orElseThrow(
        		() -> new EntityNotFoundException("ID não encontrado " + id) );
    }

    public Optional<PessoaCadastroModel> findByCpf(String cpf) {
        return pessoaRepository.findByCpf(cpf);
    }

    public PessoaCadastroModel novaPessoa(PessoaCadastroModel novaPessoa) {
   	
        @SuppressWarnings("unused")
		final Boolean cpfExistente = ExistingCpfInquiry(novaPessoa.getCpf());
        
        Long cadastroId = novaPessoa.getCadastroId();

		final UsuariosModel confereCadastroId = usuariosServices.checkInformedCadastroId(cadastroId);

        Optional<RGExpedidorModel> rgExpedidor = rgExpedidorService.buscarRGExpedidorPorId(novaPessoa.getRgIdExpedidor());
        Optional<EstadosModel> rgEstado = estadosService.buscarEstadoPorId(novaPessoa.getRgIdEstado());
        Optional<CidadesModel> nascCidade = cidadesService.buscarCidadePorId(novaPessoa.getNascIdCidade());
        Optional<EstadosModel> nascEstado = estadosService.buscarEstadoPorId(novaPessoa.getNascIdEstado());
        Optional<NacionalidadesModel> nascNacionalidade = nacionalidadesService.buscarNacionalidadePorId(novaPessoa.getNascIdNacionalidade());

        if (rgExpedidor.isPresent()) {
            novaPessoa.setRgExpedidor(rgExpedidor.get());
        }

        if (rgEstado.isPresent()) {
            novaPessoa.setRgEstado(rgEstado.get());
        }

        if (nascCidade.isPresent()) {
            novaPessoa.setNascCidade(nascCidade.get());
        }

        if (nascEstado.isPresent()) {
            novaPessoa.setNascEstado(nascEstado.get());
        }

        if (nascNacionalidade.isPresent()) {
            novaPessoa.setNascNacionalidade(nascNacionalidade.get());
        }

        novaPessoa.setCadastro(confereCadastroId);

        return pessoaRepository.save(novaPessoa);
    }
    
    public Boolean ExistingCpfInquiry(String cpf) {
    	if (cpf==null || cpf.isEmpty()) {
            new IDNotFoundException("O CPF não foi informado.");
    	}

        Optional<PessoaCadastroModel> pessoaExistente = findByCpf(cpf);
        if (pessoaExistente.isPresent()) {
            new DuplicatedRegisterException("O CPF informado já existe cadastrado.");
        }
        return pessoaExistente.isPresent();
    }

    public PessoaCadastroModel checkInformedIdPessoa (Long idPessoa) {
    	if (idPessoa==null || idPessoa<1) {
            new IDNotFoundException("O ID Pessoa não foi informado");
    	}
    	
        PessoaCadastroModel pessoa = findById(idPessoa);
        return pessoa;
    }

}
