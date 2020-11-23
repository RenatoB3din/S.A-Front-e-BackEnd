package br.sc.senai.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "fornecedor",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "razaoSocial"),
                @UniqueConstraint(columnNames = "cnpj")
        })
public class Fornecedor {

    @Id
    @Column(name = "id_fornecedor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(name = "nome_fantasia")
    @Size(min = 3, max = 100)
    private String nomeFantasia;

    @NotBlank
    @Size(min = 3, max = 100)
    private String razaoSocial;

    @NotBlank
    @Size(min = 11, max = 18)
    private String cnpj;

    @NotBlank
    @Column(name = "responsavel_fornecedor")
    private String nomeContato;

    @NotBlank
    @Column(name = "telefone_fornecedor")
    private String telefone;

    @NotBlank
    @Column(name = "email_fornecedor")
    @Email
    private String email;

    @NotBlank
    private String cep;

    @NotBlank
    private String logradouro;

    @NotBlank
    private String complemento;

    private String outroComplemento;

    @NotBlank
    private String bairro;

    @NotBlank
    private String localidade;

    @NotBlank
    private String uf;


    @Enumerated(value = EnumType.STRING)
    @Column(name = "tipo_endereco")
    private EEndereco tipoEndereco;


    @OneToMany(mappedBy = "fornecedor")
    private Set<MovimentoEstoque> movimentoEstoques;

    public Fornecedor(){}

    public Fornecedor(Integer id, String nomeFantasia, String razaoSocial, String cnpj, String nomeContato, String telefone, String email, String cep, String logradouro, String complemento, String outroComplemento, String bairro, String localidade, String uf) {
        this.id = id;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.nomeContato = nomeContato;
        this.telefone = telefone;
        this.email = email;
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.outroComplemento = outroComplemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getOutroComplemento() {
        return outroComplemento;
    }

    public void setOutroComplemento(String outroComplemento) {
        this.outroComplemento = outroComplemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public EEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(EEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public Set<MovimentoEstoque> getMovimentoEstoques() {
        return movimentoEstoques;
    }

    public void setMovimentoEstoques(Set<MovimentoEstoque> movimentoEstoques) {
        this.movimentoEstoques = movimentoEstoques;
    }
}