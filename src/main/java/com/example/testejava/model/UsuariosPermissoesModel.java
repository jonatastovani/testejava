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
@Table(name = "tab_usuariospermissoes")
public class UsuariosPermissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idUsuario", referencedColumnName = "id")
    private UsuariosModel usuario;

    @ManyToOne
    @JoinColumn(name = "idPermissao", referencedColumnName = "id")
    private PermissoesModel permissao;

    @ColumnDefault("false")
    private Boolean temporario;

    @ManyToOne
    @JoinColumn(name = "idBoletimPermissao", referencedColumnName = "id")
    private ChefiaBoletimModel boletimPermissao;

    @ColumnDefault("false")
    private Boolean substituto;

    private Date dataInicio;

    private Date dataTermino;

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

	public UsuariosModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuariosModel usuario) {
		this.usuario = usuario;
	}

	public PermissoesModel getPermissao() {
		return permissao;
	}

	public void setPermissao(PermissoesModel permissao) {
		this.permissao = permissao;
	}

	public Boolean getTemporario() {
		return temporario;
	}

	public void setTemporario(Boolean temporario) {
		this.temporario = temporario;
	}

	public ChefiaBoletimModel getBoletimPermissao() {
		return boletimPermissao;
	}

	public void setBoletimPermissao(ChefiaBoletimModel boletimPermissao) {
		this.boletimPermissao = boletimPermissao;
	}

	public Boolean getSubstituto() {
		return substituto;
	}

	public void setSubstituto(Boolean substituto) {
		this.substituto = substituto;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
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
		UsuariosPermissoesModel other = (UsuariosPermissoesModel) obj;
		return Objects.equals(id, other.id);
	}

}
