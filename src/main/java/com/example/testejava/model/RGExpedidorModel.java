package com.example.testejava.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Listagem de emissores de RG 
 */
@Entity
@Table(name = "tab_orgao_expedidor")
public class RGExpedidorModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String nome;

	@Column(nullable = false)
	private String sigla;

	@ManyToOne
	@JoinColumn(name = "tab_orgao_expedidor_tipo", referencedColumnName = "id", nullable = false)
	private RGExpedidorTipoModel tipoexpedidor;

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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public RGExpedidorTipoModel getTipoexpedidor() {
		return tipoexpedidor;
	}

	public void setTipoexpedidor(RGExpedidorTipoModel tipoexpedidor) {
		this.tipoexpedidor = tipoexpedidor;
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
		RGExpedidorModel other = (RGExpedidorModel) obj;
		return Objects.equals(id, other.id);
	}
	
}
