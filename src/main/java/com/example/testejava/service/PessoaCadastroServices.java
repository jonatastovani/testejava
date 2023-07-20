package com.example.testejava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.testejava.exception.CustomException;
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
    UsuariosServices repositoryUsuarios;
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

        try {
            Boolean cpfExistente = consultaCPFExistente(novaPessoa.getCpf());

            if (cpfExistente == true) {
                throw new CustomException("CPF_DUPLICADO", "O CPF informado já existe cadastrado.", HttpStatus.CONFLICT);
            }
            Long cadastroId = novaPessoa.getCadastroId();

            if (cadastroId == null) {
                throw new CustomException("ID_CADASTRO_NÃO_INFORMADO", "O ID do usuário de cadastro não foi informado", HttpStatus.BAD_REQUEST);
            }

            Optional<UsuariosModel> cadastro = repositoryUsuarios.buscarUsuarioPorId(cadastroId);

            if (!cadastro.isPresent()) {
                throw new CustomException("ID_CADASTRO_INEXISTENTE", "O usuário de cadastro não existe", HttpStatus.NOT_FOUND);
            }

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

            novaPessoa.setCadastro(cadastro.get());

            return repository.save(novaPessoa);

        } catch (CustomException ex) {
            throw ex;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new CustomException("UNKNOWN_ERROR", "Ocorreu um erro ao cadastrar a nova pessoa", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Boolean consultaCPFExistente(String cpf) {
        Optional<PessoaCadastroModel> pessoaExistente = buscarPessoaPorCpf(cpf);
        return pessoaExistente.isPresent();
    }
}
