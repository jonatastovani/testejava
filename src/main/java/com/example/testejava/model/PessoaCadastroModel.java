package com.example.testejava.model;

import java.sql.Date;
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
import jakarta.persistence.Transient;

@Entity
@Table(name = "pessoa_cadastro")
public class PessoaCadastroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
    
    private String nomeSocial;
    
    private String rg;
    
    @Transient
    private Long rgIdExpedidor;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rgIdExpedidor", referencedColumnName = "id")
    private RGExpedidorModel rgExpedidor;
    
    @Transient
    private Long rgIdEstado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rgIdEstado", referencedColumnName = "id")
    private EstadosModel rgEstado;
    
    @Column(length = 14, unique = true)
    private String cpf;
    
    private String nomePai;
    
    private String nomeMae;
    
    private String observacoes;
    
    @Transient
    private Long nascIdNacionalidade;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nascIdNacionalidade", referencedColumnName = "id")
    private NacionalidadesModel nascNacionalidade;
    
    @Transient
    private Long nascIdEstado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nascIdEstado", referencedColumnName = "id")
    private EstadosModel nascEstado;

    @Transient
    private Long nascIdCidade;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nascIdCidade", referencedColumnName = "id")
    private CidadesModel nascCidade;
    
    private Date nascData;
    
    private String endEndereco;

    private String endNumero;
    
    private String endBairro;

    private String endComplemento;

    private String endCep;
    
    @Transient
    private Long endIdCidadeMorad;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "endIdCidadeMorad", referencedColumnName = "id")
    private CidadesModel endCidadeMorad;
    
    @Transient
    private Long endIdEstadoMorad;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "endIdEstadoMorad", referencedColumnName = "id")
    private EstadosModel endEstadoMorad;

    @Transient
    private Long cadastroId;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cadastroId", referencedColumnName = "id")
    private UsuariosModel cadastro;

    @Column(length = 15)
    private String cadastroIp;

    @Column(nullable = false)
    private LocalDateTime cadastroData;

    @Transient
    private Long atualizacaoId;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "atualizacaoId", referencedColumnName = "id")
    private UsuariosModel atualizacao;

    @Column(length = 15)
    private String atualizacaoIp;

    private LocalDateTime atualizacaoData;

    @Transient
    private Long exclusoregistroId;

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

	public String getNomeSocial() {
		return nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Long getRgIdExpedidor() {
		return rgIdExpedidor;
	}

	public void setRgIdExpedidor(Long rgIdExpedidor) {
		this.rgIdExpedidor = rgIdExpedidor;
	}

	public RGExpedidorModel getRgExpedidor() {
		return rgExpedidor;
	}

	public void setRgExpedidor(RGExpedidorModel rgExpedidor) {
		this.rgExpedidor = rgExpedidor;
	}

	public Long getRgIdEstado() {
		return rgIdEstado;
	}

	public void setRgIdEstado(Long rgIdEstado) {
		this.rgIdEstado = rgIdEstado;
	}

	public EstadosModel getRgEstado() {
		return rgEstado;
	}

	public void setRgEstado(EstadosModel rgEstado) {
		this.rgEstado = rgEstado;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Long getNascIdNacionalidade() {
		return nascIdNacionalidade;
	}

	public void setNascIdNacionalidade(Long nascIdNacionalidade) {
		this.nascIdNacionalidade = nascIdNacionalidade;
	}

	public NacionalidadesModel getNascNacionalidade() {
		return nascNacionalidade;
	}

	public void setNascNacionalidade(NacionalidadesModel nascNacionalidade) {
		this.nascNacionalidade = nascNacionalidade;
	}

	public Long getNascIdEstado() {
		return nascIdEstado;
	}

	public void setNascIdEstado(Long nascIdEstado) {
		this.nascIdEstado = nascIdEstado;
	}

	public EstadosModel getNascEstado() {
		return nascEstado;
	}

	public void setNascEstado(EstadosModel nascEstado) {
		this.nascEstado = nascEstado;
	}

	public Long getNascIdCidade() {
		return nascIdCidade;
	}

	public void setNascIdCidade(Long nascIdCidade) {
		this.nascIdCidade = nascIdCidade;
	}

	public CidadesModel getNascCidade() {
		return nascCidade;
	}

	public void setNascCidade(CidadesModel nascCidade) {
		this.nascCidade = nascCidade;
	}

	public Date getNascData() {
		return nascData;
	}

	public void setNascData(Date nascData) {
		this.nascData = nascData;
	}

	public String getEndEndereco() {
		return endEndereco;
	}

	public void setEndEndereco(String endEndereco) {
		this.endEndereco = endEndereco;
	}

	public String getEndNumero() {
		return endNumero;
	}

	public void setEndNumero(String endNumero) {
		this.endNumero = endNumero;
	}

	public String getEndBairro() {
		return endBairro;
	}

	public void setEndBairro(String endBairro) {
		this.endBairro = endBairro;
	}

	public String getEndComplemento() {
		return endComplemento;
	}

	public void setEndComplemento(String endComplemento) {
		this.endComplemento = endComplemento;
	}

	public String getEndCep() {
		return endCep;
	}

	public void setEndCep(String endCep) {
		this.endCep = endCep;
	}

	public Long getEndIdCidadeMorad() {
		return endIdCidadeMorad;
	}

	public void setEndIdCidadeMorad(Long endIdCidadeMorad) {
		this.endIdCidadeMorad = endIdCidadeMorad;
	}

	public CidadesModel getEndCidadeMorad() {
		return endCidadeMorad;
	}

	public void setEndCidadeMorad(CidadesModel endCidadeMorad) {
		this.endCidadeMorad = endCidadeMorad;
	}

	public Long getEndIdEstadoMorad() {
		return endIdEstadoMorad;
	}

	public void setEndIdEstadoMorad(Long endIdEstadoMorad) {
		this.endIdEstadoMorad = endIdEstadoMorad;
	}

	public EstadosModel getEndEstadoMorad() {
		return endEstadoMorad;
	}

	public void setEndEstadoMorad(EstadosModel endEstadoMorad) {
		this.endEstadoMorad = endEstadoMorad;
	}

	public Long getCadastroId() {
		return cadastroId;
	}

	public void setCadastroId(Long cadastroId) {
		this.cadastroId = cadastroId;
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

	public Long getAtualizacaoId() {
		return atualizacaoId;
	}

	public void setAtualizacaoId(Long atualizacaoId) {
		this.atualizacaoId = atualizacaoId;
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

	public Long getExclusoregistroId() {
		return exclusoregistroId;
	}

	public void setExclusoregistroId(Long exclusoregistroId) {
		this.exclusoregistroId = exclusoregistroId;
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
		PessoaCadastroModel other = (PessoaCadastroModel) obj;
		return Objects.equals(id, other.id);
	}

}
