package com.example.testejava.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tab_usuarios")
public class UsuariosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean status;

    @Column(nullable = false, unique = true)
    private String usuario;

    @Column(unique = true)
    private Integer rsUsuario;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true)
    private String apelido;

    private int idExibicao;

    private String senha;

    private String rg;

    @Column(nullable = false, unique = true)
    private String cpf;

    private Integer idTurno;

    private Integer idEscala;

    private boolean contaBloqueada;

    private LocalDateTime dataContaBloqueada;

    private boolean contaExcluida;

    private LocalDateTime dataContaExcluida;

    private Integer idCadastro;

    private String ipCadastro;

    private LocalDateTime dataCadastro;

    private Integer idAtualizacao;

    private String ipAtualizacao;

    private LocalDateTime dataAtualizacao;

    private Integer idExclusoRegistro;

    private String ipExclusoRegistro;

    private LocalDateTime dataExclusoRegistro;

    
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Integer getRsUsuario() {
		return rsUsuario;
	}

	public void setRsUsuario(Integer rsUsuario) {
		this.rsUsuario = rsUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getIdTurno() {
		return idTurno;
	}

	public void setIdTurno(Integer idTurno) {
		this.idTurno = idTurno;
	}

	public Integer getIdEscala() {
		return idEscala;
	}

	public void setIdEscala(Integer idEscala) {
		this.idEscala = idEscala;
	}

	public boolean isContaBloqueada() {
		return contaBloqueada;
	}

	public void setContaBloqueada(boolean contaBloqueada) {
		this.contaBloqueada = contaBloqueada;
	}

	public LocalDateTime getDataContaBloqueada() {
		return dataContaBloqueada;
	}

	public void setDataContaBloqueada(LocalDateTime dataContaBloqueada) {
		this.dataContaBloqueada = dataContaBloqueada;
	}

	public boolean isContaExcluida() {
		return contaExcluida;
	}

	public void setContaExcluida(boolean contaExcluida) {
		this.contaExcluida = contaExcluida;
	}

	public LocalDateTime getDataContaExcluida() {
		return dataContaExcluida;
	}

	public void setDataContaExcluida(LocalDateTime dataContaExcluida) {
		this.dataContaExcluida = dataContaExcluida;
	}

	public int getNomeExibicao() {
		return idExibicao;
	}

	public void setNomeExibicao(int nomeExibicao) {
		this.idExibicao = nomeExibicao;
	}

	public Integer getIdCadastro() {
		return idCadastro;
	}

	public void setIdCadastro(Integer idCadastro) {
		this.idCadastro = idCadastro;
	}

	public String getIpCadastro() {
		return ipCadastro;
	}

	public void setIpCadastro(String ipCadastro) {
		this.ipCadastro = ipCadastro;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Integer getIdAtualizacao() {
		return idAtualizacao;
	}

	public void setIdAtualizacao(Integer idAtualizacao) {
		this.idAtualizacao = idAtualizacao;
	}

	public String getIpAtualizacao() {
		return ipAtualizacao;
	}

	public void setIpAtualizacao(String ipAtualizacao) {
		this.ipAtualizacao = ipAtualizacao;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Integer getIdExclusoRegistro() {
		return idExclusoRegistro;
	}

	public void setIdExclusoRegistro(Integer idExclusoRegistro) {
		this.idExclusoRegistro = idExclusoRegistro;
	}

	public String getIpExclusoRegistro() {
		return ipExclusoRegistro;
	}

	public void setIpExclusoRegistro(String ipExclusoRegistro) {
		this.ipExclusoRegistro = ipExclusoRegistro;
	}

	public LocalDateTime getDataExclusoRegistro() {
		return dataExclusoRegistro;
	}

	public void setDataExclusoRegistro(LocalDateTime dataExclusoRegistro) {
		this.dataExclusoRegistro = dataExclusoRegistro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuariosModel other = (UsuariosModel) obj;
		return Objects.equals(id, other.id);
	}

}
