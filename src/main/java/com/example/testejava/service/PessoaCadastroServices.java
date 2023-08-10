package com.example.testejava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.testejava.exception.CustomRuntimeException;
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
    UsuariosServices usuariosService;
    @Autowired
    RGExpedidorService rgExpedidorService;
    @Autowired
    EstadosService estadosService;
    @Autowired
    CidadesService cidadesService;
    @Autowired
    NacionalidadesService nacionalidadesService;

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
		final Boolean cpfExistente = consultaCPFExistente(novaPessoa.getCpf());
        
        Long cadastroId = novaPessoa.getCadastroId();

		final Optional<UsuariosModel> confereCadastroId = usuariosService.verificaIdCadastroInformado(cadastroId);

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

    public Boolean consultaCPFExistente(String cpf) {
    	if (cpf==null || cpf.isEmpty()) {
            throw new CustomRuntimeException("CPF_NÃO_INFORMADO", "O CPF não foi informado.", HttpStatus.BAD_REQUEST);
    	}

        Optional<PessoaCadastroModel> pessoaExistente = buscarPessoaPorCpf(cpf);
        if (pessoaExistente.isPresent()) {
            throw new CustomRuntimeException("CPF_DUPLICADO", "O CPF informado já existe cadastrado.", HttpStatus.CONFLICT);
        }
        return pessoaExistente.isPresent();
    }

    public Optional<PessoaCadastroModel> verificaIdPessoaInformado (Long pessoaId) {
    	if (pessoaId==null || pessoaId<1) {
            throw new CustomRuntimeException("ID_PESSOA_NÃO_INFORMADO", "O ID Pessoa não foi informado", HttpStatus.BAD_REQUEST);
    	}
    	
        Optional<PessoaCadastroModel> pessoa = buscarPessoaPorId(pessoaId);

        if (!pessoa.isPresent()) {
            throw new CustomRuntimeException("ID_PESSOA_INEXISTENTE", "O ID Pessoa informado não existe", HttpStatus.NOT_FOUND);
        }
        
        return pessoa;
    }
}
