package com.example.testejava.model;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cimic_artigos")
public class CimicArtigosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cadastroId", referencedColumnName = "id", nullable = false)
    private UsuariosModel cadastro;

    @Column(length = 15)
    private String cadastroIp;

    @Column(nullable = false)
    private LocalDateTime cadastroData;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "atualizacaoId", referencedColumnName = "id")
    private UsuariosModel atualizacao;

    @Column(length = 15)
    private String atualizacaoIp;

    private LocalDateTime atualizacaoData;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "exclusoregistroId", referencedColumnName = "id")
    private UsuariosModel exclusoregistro;

    @Column(length = 15)
    private String exclusoregistroIp;

    private LocalDateTime exclusoregistroData;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public UsuariosModel getCadastro() {
		return cadastro;
	}

	public void setCadastro(UsuariosModel cadastro) {
		this.cadastro = cadastro;
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

	public UsuariosModel getAtualizacao() {
		return atualizacao;
	}

	public void setAtualizacao(UsuariosModel atualizacao) {
		this.atualizacao = atualizacao;
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

	public UsuariosModel getExclusoregistro() {
		return exclusoregistro;
	}

	public void setExclusoregistro(UsuariosModel exclusoregistro) {
		this.exclusoregistro = exclusoregistro;
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
		CimicArtigosModel other = (CimicArtigosModel) obj;
		return Objects.equals(id, other.id);
	}

}
