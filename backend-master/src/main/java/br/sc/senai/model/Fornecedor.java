package br.sc.senai.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cadfornec")
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "relfornecendereco",
            joinColumns = @JoinColumn(name = "id_fornecedor"),
            inverseJoinColumns = @JoinColumn(name = "id_endereco")
    )
    private Set<FornecedorEndereco> fornecedorEnderecos = new HashSet<FornecedorEndereco>();

    // TODO: 25/07/2020 >>> Verificar uma forma para cadastrar o id do fornecedor em uma tabela sem ter a tabela de referência
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fornecedor")

    public Fornecedor(){}

    public Fornecedor(Integer id, String nomeFantasia, String razaoSocial, String cnpj) {
        this.id = id;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
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

    public Set<FornecedorEndereco> getFornecedorEnderecos() {
        return fornecedorEnderecos;
    }

    public void setFornecedorEnderecos(Set<FornecedorEndereco> fornecedorEnderecos) {
        this.fornecedorEnderecos = fornecedorEnderecos;
    }
}