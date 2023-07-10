package com.example.testejava.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tab_turnos")
public class TurnosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false)
    private boolean periodoDiurno;

    private Long idTurnoSeguinte;

    private Long idPermissao;

    @Column(nullable = false, columnDefinition = "INT(11) DEFAULT 53")
    private Long idDiretorCarceregem;

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

	public boolean isPeriodoDiurno() {
		return periodoDiurno;
	}

	public void setPeriodoDiurno(boolean periodoDiurno) {
		this.periodoDiurno = periodoDiurno;
	}

	public Long getIdTurnoSeguinte() {
		return idTurnoSeguinte;
	}

	public void setIdTurnoSeguinte(Long idTurnoSeguinte) {
		this.idTurnoSeguinte = idTurnoSeguinte;
	}

	public Long getIdPermissao() {
		return idPermissao;
	}

	public void setIdPermissao(Long idPermissao) {
		this.idPermissao = idPermissao;
	}

	public Long getIdDiretorCarceregem() {
		return idDiretorCarceregem;
	}

	public void setIdDiretorCarceregem(Long idDiretorCarceregem) {
		this.idDiretorCarceregem = idDiretorCarceregem;
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
