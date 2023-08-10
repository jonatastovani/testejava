package com.example.testejava.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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
    
    @NotBlank(message = "O campo Nome de Usuário não pode ser nulo ou vazio!")
    @Column(nullable = false, unique = true)
    private String usuario;

    @NotNull(message = "O campo RS Usuário não pode ser nulo ou vazio!")
    @Column(unique = true)
    private Integer rsUsuario;

    @NotNull(message = "O ID Pessoa não pode ser nulo ou vazio!")
    @Transient
    private Long idPessoa;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPessoa", referencedColumnName = "id", nullable = false)
    private PessoaCadastroModel pessoa;

    @Column(unique = true)
    private String apelido;

    private Long idExibicao;

    private String senha;

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

    private Long cadastroId;

    @Column(length = 15)
    private String cadastroIp;

    @Column(nullable = false)
    private LocalDateTime cadastroData;

    private Long atualizacaoId;

    @Column(length = 15)
    private String atualizacaoIp;

    private LocalDateTime atualizacaoData;

    private Long exclusoregistroId;

    @Column(length = 15)
    private String exclusoregistroIp;

    private LocalDateTime exclusoregistroData;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
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

	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public PessoaCadastroModel getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaCadastroModel pessoa) {
		this.pessoa = pessoa;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public Long getIdExibicao() {
		return idExibicao;
	}

	public void setIdExibicao(Long idExibicao) {
		this.idExibicao = idExibicao;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

	public Boolean getContaBloqueada() {
		return contaBloqueada;
	}

	public void setContaBloqueada(Boolean contaBloqueada) {
		this.contaBloqueada = contaBloqueada;
	}

	public LocalDateTime getDataContaBloqueada() {
		return dataContaBloqueada;
	}

	public void setDataContaBloqueada(LocalDateTime dataContaBloqueada) {
		this.dataContaBloqueada = dataContaBloqueada;
	}

	public Boolean getContaExcluida() {
		return contaExcluida;
	}

	public void setContaExcluida(Boolean contaExcluida) {
		this.contaExcluida = contaExcluida;
	}

	public LocalDateTime getDataContaExcluida() {
		return dataContaExcluida;
	}

	public void setDataContaExcluida(LocalDateTime dataContaExcluida) {
		this.dataContaExcluida = dataContaExcluida;
	}

	public Long getCadastroId() {
		return cadastroId;
	}

	public void setCadastroId(Long cadastroId) {
		this.cadastroId = cadastroId;
	}

	public String getCadastroIp() {
		return cadastroIp;
	}

	public void setCadastroIp(String cadastroIp) {
		this.cadastroIp = cadastroIp;
	}

	public LocalDateTime getCadastroData() {
		return cadastroData;
	}

	public void setCadastroData(LocalDateTime cadastroData) {
		this.cadastroData = cadastroData;
	}

	public Long getAtualizacaoId() {
		return atualizacaoId;
	}

	public void setAtualizacaoId(Long atualizacaoId) {
		this.atualizacaoId = atualizacaoId;
	}

	public String getAtualizacaoIp() {
		return atualizacaoIp;
	}

	public void setAtualizacaoIp(String atualizacaoIp) {
		this.atualizacaoIp = atualizacaoIp;
	}

	public LocalDateTime getAtualizacaoData() {
		return atualizacaoData;
	}

	public void setAtualizacaoData(LocalDateTime atualizacaoData) {
		this.atualizacaoData = atualizacaoData;
	}

	public Long getExclusoregistroId() {
		return exclusoregistroId;
	}

	public void setExclusoregistroId(Long exclusoregistroId) {
		this.exclusoregistroId = exclusoregistroId;
	}

	public String getExclusoregistroIp() {
		return exclusoregistroIp;
	}

	public void setExclusoregistroIp(String exclusoregistroIp) {
		this.exclusoregistroIp = exclusoregistroIp;
	}

	public LocalDateTime getExclusoregistroData() {
		return exclusoregistroData;
	}

	public void setExclusoregistroData(LocalDateTime exclusoregistroData) {
		this.exclusoregistroData = exclusoregistroData;
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
