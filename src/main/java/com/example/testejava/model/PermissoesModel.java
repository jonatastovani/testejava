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
@Table(name = "tab_permissoes")
public class PermissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    private Long idTurno;

    @Column(nullable = false)
    @ColumnDefault("false")
    private Boolean diretor;

    private String nomeCompleto;

    @ManyToOne
    @JoinColumn(name = "idSetorPai", referencedColumnName = "id")
    private PermissoesModel setorPai;

    @ManyToOne
    @JoinColumn(name = "idGrupoPai", referencedColumnName = "id")
    private PermissoesGrupoModel grupoPai;

    @ManyToOne
    @JoinColumn(name = "idGrupo", referencedColumnName = "id")
    private PermissoesGrupoModel grupo;

    private Integer ordem;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getIdTurno() {
		return idTurno;
	}

	public void setIdTurno(Long idTurno) {
		this.idTurno = idTurno;
	}

	public Boolean getDiretor() {
		return diretor;
	}

	public void setDiretor(Boolean diretor) {
		this.diretor = diretor;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public PermissoesModel getSetorPai() {
		return setorPai;
	}

	public void setSetorPai(PermissoesModel setorPai) {
		this.setorPai = setorPai;
	}

	public PermissoesGrupoModel getGrupoPai() {
		return grupoPai;
	}

	public void setGrupoPai(PermissoesGrupoModel grupoPai) {
		this.grupoPai = grupoPai;
	}

	public PermissoesGrupoModel getGrupo() {
		return grupo;
	}

	public void setGrupo(PermissoesGrupoModel grupo) {
		this.grupo = grupo;
	}

	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
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
		PermissoesModel other = (PermissoesModel) obj;
		return Objects.equals(id, other.id);
	}

}
