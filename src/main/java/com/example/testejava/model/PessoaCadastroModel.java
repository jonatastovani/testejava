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
@Table(name = "pessoa_cadastro")
public class PessoaCadastroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private String nomesocial;
    
    private String rg;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idEmissorRg", referencedColumnName = "id")
    private RGExpedidorModel expedidorrg;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idEstadoRg", referencedColumnName = "id")
    private EstadosModel estadorg;
    
    @Column(length = 14)
    private String cpf;
    
    private String nomePai;
    
    private String nomeMae;
    
    private String observacoes;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idNacionalidade", referencedColumnName = "id")
    private NacionalidadesModel nacionalidade;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCidadeNasc", referencedColumnName = "id")
    private CidadesModel cidadenasc;
    
    private Date dataNasc;
    
    @ColumnDefault("false")
    private Boolean emancipado;
    
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomesocial() {
		return nomesocial;
	}

	public void setNomesocial(String nomesocial) {
		this.nomesocial = nomesocial;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public RGExpedidorModel getExpedidorrg() {
		return expedidorrg;
	}

	public void setExpedidorrg(RGExpedidorModel expedidorrg) {
		this.expedidorrg = expedidorrg;
	}

	public EstadosModel getEstadorg() {
		return estadorg;
	}

	public void setEstadorg(EstadosModel estadorg) {
		this.estadorg = estadorg;
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

	public NacionalidadesModel getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(NacionalidadesModel nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public CidadesModel getCidadenasc() {
		return cidadenasc;
	}

	public void setCidadenasc(CidadesModel cidadenasc) {
		this.cidadenasc = cidadenasc;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Boolean getEmancipado() {
		return emancipado;
	}

	public void setEmancipado(Boolean emancipado) {
		this.emancipado = emancipado;
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
