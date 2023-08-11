package com.example.testejava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testejava.model.CidadesModel;
import com.example.testejava.model.EstadosModel;
import com.example.testejava.model.NacionalidadesModel;
import com.example.testejava.model.PessoaCadastroModel;
import com.example.testejava.model.RGExpedidorModel;
import com.example.testejava.model.UsuariosModel;
import com.example.testejava.repository.PessoaCadastroRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaCadastroServices {

    @Autowired
    PessoaCadastroRepository repository;
    
    @Autowired
    RGExpedidorService rgExpedidorService;
    @Autowired
    EstadosService estadosService;
    @Autowired
    CidadesService cidadesService;
    @Autowired
    NacionalidadesService nacionalidadesService;

    @Autowired
    UsuariosVerificacoesService usuariosVerificacoesService;
    
    @Autowired
    PessoaCadastroVerificacoesService pessoaVerificacoesService;

    public List<PessoaCadastroModel> buscarTodasPessoas() {
        return repository.findAll();
    }

    public Optional<PessoaCadastroModel> buscarPessoaPorId(Long id) {
        return repository.findById(id);
    }

    public Optional<PessoaCadastroModel> buscarPessoaPorCpf(String cpf) {
        return repository.findByCpf(cpf);
    }

    public PessoaCadastroModel novaPessoa(PessoaCadastroModel novaPessoa) {
   	
        @SuppressWarnings("unused")
		final Boolean cpfExistente = pessoaVerificacoesService.consultaCPFExistente(novaPessoa.getCpf());
        
        Long cadastroId = novaPessoa.getCadastroId();

		final Optional<UsuariosModel> confereCadastroId = usuariosVerificacoesService.verificaIdCadastroInformado(cadastroId);

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

        novaPessoa.setCadastro(confereCadastroId.get());

        return repository.save(novaPessoa);
    }

}
