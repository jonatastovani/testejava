/**
 * 
 */
package com.example.testejava.model;

import java.time.LocalTime;
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

/**
 * Armazena as configurações da unidade vigente
 */
@Entity
@Table(name = "tab_dadosunidade")
public class DadosUnidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@ManyToOne
	//@JoinColumn(name = "idUnidade", referencedColumnName = "id", nullable = false)
	//private UnidadesModel unidade;
	
	@Column(nullable = false)
//	@ColumnDefault("06:00")
	private LocalTime  horaPlantaoAsp;
	
	@Column(nullable = false)
//	@ColumnDefault("07:00")
	private LocalTime  horaPlantaoAevp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
//
//	public UnidadesModel getUnidade() {
//		return unidade;
//	}
//
//	public void setUnidade(UnidadesModel unidade) {
//		this.unidade = unidade;
//	}

	public LocalTime  getHoraPlantaoAsp() {
		return horaPlantaoAsp;
	}

	public void setHoraPlantaoAsp(LocalTime  horaPlantaoAsp) {
		this.horaPlantaoAsp = horaPlantaoAsp;
	}

	public LocalTime  getHoraPlantaoAevp() {
		return horaPlantaoAevp;
	}

	public void setHoraPlantaoAevp(LocalTime  horaPlantaoAevp) {
		this.horaPlantaoAevp = horaPlantaoAevp;
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
		DadosUnidade other = (DadosUnidade) obj;
		return Objects.equals(id, other.id);
	}
	
}
