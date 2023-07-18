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
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rgIdExpedidor", referencedColumnName = "id")
    private RGExpedidorModel rgexpedidor;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rgIdEstado", referencedColumnName = "id")
    private EstadosModel rgestador;
    
    @Column(length = 14)
    private String cpf;
    
    private String nomePai;
    
    private String nomeMae;
    
    private String observacoes;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nascIdNacionalidade", referencedColumnName = "id")
    private NacionalidadesModel nascnacionalidade;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nascIdEstado", referencedColumnName = "id")
    private EstadosModel nascestado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nascIdCidade", referencedColumnName = "id")
    private CidadesModel nasccidade;
    
    private Date nascData;
    
    private String endEndereco;

    private String endNumero;
    
    private String endBairro;

    private String endComplemento;

    private String endCep;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "endIdCidadeMorad", referencedColumnName = "id")
    private CidadesModel endcidademorad;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "endIdEstadoMorad", referencedColumnName = "id")
    private EstadosModel endestadomorad;

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

	public RGExpedidorModel getRgexpedidor() {
		return rgexpedidor;
	}

	public void setRgexpedidor(RGExpedidorModel rgexpedidor) {
		this.rgexpedidor = rgexpedidor;
	}

	public EstadosModel getRgestador() {
		return rgestador;
	}

	public void setRgestador(EstadosModel rgestador) {
		this.rgestador = rgestador;
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

	public NacionalidadesModel getNascnacionalidade() {
		return nascnacionalidade;
	}

	public void setNascnacionalidade(NacionalidadesModel nascnacionalidade) {
		this.nascnacionalidade = nascnacionalidade;
	}

	public EstadosModel getNascestado() {
		return nascestado;
	}

	public void setNascestado(EstadosModel nascestado) {
		this.nascestado = nascestado;
	}

	public CidadesModel getNasccidade() {
		return nasccidade;
	}

	public void setNasccidade(CidadesModel nasccidade) {
		this.nasccidade = nasccidade;
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

	public CidadesModel getEndcidademorad() {
		return endcidademorad;
	}

	public void setEndcidademorad(CidadesModel endcidademorad) {
		this.endcidademorad = endcidademorad;
	}

	public EstadosModel getEndestadomorad() {
		return endestadomorad;
	}

	public void setEndestadomorad(EstadosModel endestadomorad) {
		this.endestadomorad = endestadomorad;
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
