/**
 * 
 */
package com.example.testejava.model;

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

/**
 * Tabela de informações de todas unidades do Estado
 */
@Entity
@Table(name = "tab_unidades")
public class UnidadesModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idCidade", referencedColumnName = "id", nullable = false)
	private CidadesModel cidade;
	
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idPerfil", referencedColumnName = "id", nullable = false)
	private UnidadesPerfilModel perfil;
	
	@Column(length = 5, nullable = false, unique = true)
	private String codigo;
	
	@Column(nullable = false)
	private String nomeUnidade;
	
	private String nomeAtribuido;
	
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idTipoUnidade", referencedColumnName = "id", nullable = false)
	private UnidadesTiposModel tipounidade;
	
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idCoordenadoria", referencedColumnName = "id", nullable = false)
	private UnidadesCoordenadorias coordenadoria;
	
	@Column(nullable = false)
	private String diretor;
	
	private String emailNotes;
	
	private String emailCimic;
	
	private String endereco;
	
	private String cep;
	
	private String telefone;

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

	public CidadesModel getCidade() {
		return cidade;
	}

	public void setCidade(CidadesModel cidade) {
		this.cidade = cidade;
	}

	public UnidadesPerfilModel getPerfil() {
		return perfil;
	}

	public void setPerfil(UnidadesPerfilModel perfil) {
		this.perfil = perfil;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNomeUnidade() {
		return nomeUnidade;
	}

	public void setNomeUnidade(String nomeUnidade) {
		this.nomeUnidade = nomeUnidade;
	}

	public String getNomeAtribuido() {
		return nomeAtribuido;
	}

	public void setNomeAtribuido(String nomeAtribuido) {
		this.nomeAtribuido = nomeAtribuido;
	}

	public UnidadesTiposModel getTipounidade() {
		return tipounidade;
	}

	public void setTipounidade(UnidadesTiposModel tipounidade) {
		this.tipounidade = tipounidade;
	}

	public UnidadesCoordenadorias getCoordenadoria() {
		return coordenadoria;
	}

	public void setCoordenadoria(UnidadesCoordenadorias coordenadoria) {
		this.coordenadoria = coordenadoria;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public String getEmailNotes() {
		return emailNotes;
	}

	public void setEmailNotes(String emailNotes) {
		this.emailNotes = emailNotes;
	}

	public String getEmailCimic() {
		return emailCimic;
	}

	public void setEmailCimic(String emailCimic) {
		this.emailCimic = emailCimic;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
		UnidadesModel other = (UnidadesModel) obj;
		return Objects.equals(id, other.id);
	}

}
