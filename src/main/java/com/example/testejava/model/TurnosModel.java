package com.example.testejava.model;

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
@Table(name = "tab_turnos")
public class TurnosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nome;

    @Column(nullable = false)
    private Boolean periodoDiurno;

    //@ManyToOne
    //@JoinColumn(name = "idTurnoSeguinte", referencedColumnName = "id")
    private Long idTurnoSeguinte;

    @ManyToOne
    @JoinColumn(name = "idPermissao", referencedColumnName = "id")
    private PermissoesModel permissao;

    @ManyToOne
    @JoinColumn(name = "idDiretorCarceregem", referencedColumnName = "id")
    //@ColumnDefault("53")
    private PermissoesModel diretorCarceregem;

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

	public Boolean getPeriodoDiurno() {
		return periodoDiurno;
	}

	public void setPeriodoDiurno(Boolean periodoDiurno) {
		this.periodoDiurno = periodoDiurno;
	}

	public Long getIdTurnoSeguinte() {
		return idTurnoSeguinte;
	}

	public void setTurnoSeguinte(Long idTurnoSeguinte) {
		this.idTurnoSeguinte = idTurnoSeguinte;
	}

	public PermissoesModel getPermissao() {
		return permissao;
	}

	public void setPermissao(PermissoesModel permissao) {
		this.permissao = permissao;
	}

	public PermissoesModel getDiretorCarceregem() {
		return diretorCarceregem;
	}

	public void setDiretorCarceregem(PermissoesModel diretorCarceregem) {
		this.diretorCarceregem = diretorCarceregem;
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
		TurnosModel other = (TurnosModel) obj;
		return Objects.equals(id, other.id);
	}
	
}
