package br.sc.senai.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "fornecedor")
public class Fornecedor {

    @Id
    @Column(name = "id_fornecedor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome_fantasia")
    @Size(min = 3, max = 100)
    private String nomeFantasia;

    @Column(name = "razao_social")
    @Size(min = 3, max = 100)
    private String razaoSocial;

    @Size(min = 11, max = 14)
    private String cnpj;

    @Column(name = "nome_contato")
    private String nomeContato;

    private String telefone;

    @Email
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "relfornecendereco",
            joinColumns = @JoinColumn(name = "id_fornecedor"),
            inverseJoinColumns = @JoinColumn(name = "id_endereco")
    )
    private Set<FornecedorEndereco> fornecedorEnderecos = new HashSet<FornecedorEndereco>();

    // TODO: 25/07/2020 >>> Verificar uma forma para cadastrar o id do fornecedor em uma tabela sem ter a tabela de referência

    @OneToMany(mappedBy = "fornecedor")
    private Set<MovimentoEstoque> movimentoEstoques;

    public Fornecedor(){}

    public Fornecedor(Integer id, String nomeFantasia, String razaoSocial, String cnpj, String nomeContato, String telefone, String email) {
        this.id = id;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.nomeContato = nomeContato;
        this.telefone = telefone;
        this.email = email;
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

    public Set<FornecedorEndereco> getFornecedorEnderecos() {
        return fornecedorEnderecos;
    }

    public void setFornecedorEnderecos(Set<FornecedorEndereco> fornecedorEnderecos) {
        this.fornecedorEnderecos = fornecedorEnderecos;
    }

    public Set<MovimentoEstoque> getMovimentoEstoques() {
        return movimentoEstoques;
    }

    public void setMovimentoEstoques(Set<MovimentoEstoque> movimentoEstoques) {
        this.movimentoEstoques = movimentoEstoques;
    }
}