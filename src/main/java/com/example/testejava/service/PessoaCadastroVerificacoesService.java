package com.example.testejava.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.testejava.exception.CustomRuntimeException;
import com.example.testejava.model.PessoaCadastroModel;

@Service
public class PessoaCadastroVerificacoesService extends PessoaCadastroServices {

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
