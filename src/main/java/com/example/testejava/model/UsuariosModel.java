package com.example.testejava.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.Objects;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "tab_usuarios")
public class UsuariosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @ColumnDefault("true")
    private Boolean status;

    @Column(nullable = false, unique = true)
    private String usuario;

    @Column(unique = true)
    private Integer rsUsuario;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true)
    private String apelido;

    private Long idExibicao;

    private String senha;

    private String rg;

    @Column(nullable = false, unique = true)
    private String cpf;

    private Long idTurno;

    private Long idEscala;

    @Column(nullable = false)
    @ColumnDefault("false")
    private Boolean contaBloqueada;

    private LocalDateTime dataContaBloqueada;

    @Column(nullable = false)
    @ColumnDefault("false")
    private Boolean contaExcluida;

    private LocalDateTime dataContaExcluida;

    @Column(nullable = false)
    private Long idCadastro;

    private String ipCadastro;

    @Column(nullable = false)
    private LocalDateTime dataCadastro;

    private Long idAtualizacao;

    private String ipAtualizacao;

    private LocalDateTime dataAtualizacao;

    private Long idExclusoRegistro;

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

	public Long getIdTurno() {
		return idTurno;
	}

	public void setIdTurno(Long idTurno) {
		this.idTurno = idTurno;
	}

	public Long getIdEscala() {
		return idEscala;
	}

	public void setIdEscala(Long idEscala) {
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

	public Long getNomeExibicao() {
		return idExibicao;
	}

	public void setNomeExibicao(Long nomeExibicao) {
		this.idExibicao = nomeExibicao;
	}

	public Long getIdCadastro() {
		return idCadastro;
	}

	public void setIdCadastro(Long idCadastro) {
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

	public Long getIdAtualizacao() {
		return idAtualizacao;
	}

	public void setIdAtualizacao(Long idAtualizacao) {
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

	public Long getIdExclusoRegistro() {
		return idExclusoRegistro;
	}

	public void setIdExclusoRegistro(Long idExclusoRegistro) {
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
