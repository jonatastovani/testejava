package com.example.testejava.model;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Objects;

import org.hibernate.annotations.ColumnDefault;

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
@Table(name = "chefia_boletim")
public class ChefiaBoletimModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NUMERO")
    private Long numero;

    @ColumnDefault("false")
    private Boolean boletimDoDia;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTurno")
    private TurnosModel turno;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idDiretor")
    private UsuariosPermissoesModel diretor;

    @Column(nullable = false)
    private Date dataBoletim;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idBoletimAnterior")
    private ChefiaBoletimModel boletimAnterior;

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
    @JoinColumn(name = "exclusoRegistroId", referencedColumnName = "id")
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

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Boolean getBoletimDoDia() {
		return boletimDoDia;
	}

	public void setBoletimDoDia(Boolean boletimDoDia) {
		this.boletimDoDia = boletimDoDia;
	}

	public TurnosModel getTurno() {
		return turno;
	}

	public void setTurno(TurnosModel turno) {
		this.turno = turno;
	}

	public UsuariosPermissoesModel getDiretor() {
		return diretor;
	}

	public void setDiretor(UsuariosPermissoesModel diretor) {
		this.diretor = diretor;
	}

	public Date getDataBoletim() {
		return dataBoletim;
	}

	public void setDataBoletim(Date dataBoletim) {
		this.dataBoletim = dataBoletim;
	}

	public ChefiaBoletimModel getBoletimAnterior() {
		return boletimAnterior;
	}

	public void setBoletimAnterior(ChefiaBoletimModel boletimAnterior) {
		this.boletimAnterior = boletimAnterior;
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

	public void setexclusoregistroIp(String exclusoregistroIp) {
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
		ChefiaBoletimModel other = (ChefiaBoletimModel) obj;
		return Objects.equals(id, other.id);
	}

    
}
