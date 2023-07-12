package com.example.testejava.model;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Objects;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

    @ManyToOne
    @JoinColumn(name = "idTurno")
    private TurnosModel turno;

    @ManyToOne
    @JoinColumn(name = "idDiretor")
    private UsuariosPermissoesModel diretor;

    @Column(nullable = false)
    private Date dataBoletim;

    @ManyToOne
    @JoinColumn(name = "idBoletimAnterior")
    private ChefiaBoletimModel boletimAnterior;

    @ManyToOne
    @JoinColumn(name = "idCadastro", referencedColumnName = "id")
    private UsuariosModel cadastro;

    @Column(length = 15)
    private String ipCadastro;

    @Column(nullable = false)
    private LocalDateTime dataCadastro;

    @ManyToOne
    @JoinColumn(name = "idAtualizacao", referencedColumnName = "id")
    private UsuariosModel atualizacao;

    @Column(length = 15)
    private String ipAtualizacao;

    private LocalDateTime dataAtualizacao;

    @ManyToOne
    @JoinColumn(name = "idExclusoRegistro", referencedColumnName = "id")
    private UsuariosModel exclusoRegistro;

    @Column(length = 15)
    private String ipExclusoRegistro;

    private LocalDateTime dataExclusoRegistro;

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

	public UsuariosModel getAtualizacao() {
		return atualizacao;
	}

	public void setAtualizacao(UsuariosModel atualizacao) {
		this.atualizacao = atualizacao;
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

	public UsuariosModel getExclusoRegistro() {
		return exclusoRegistro;
	}

	public void setExclusoRegistro(UsuariosModel exclusoRegistro) {
		this.exclusoRegistro = exclusoRegistro;
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
		ChefiaBoletimModel other = (ChefiaBoletimModel) obj;
		return Objects.equals(id, other.id);
	}

    
}
