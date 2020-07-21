package br.sc.senai.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "fornecedor")
public class Fornecedor {

    @Id
    @Column(name = "id_fornecedor")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idFornecedor;

    @Column(name = "razao_social", length = 150)
    private String razaoSocial;

    @Column(name = "nome_fantasia", length = 150)
    private String nomeFantasia;

    @Column(name = "cpf_cnpj", length = 14)
    private String cnpj;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "fornecedorEndereco",
            fetch = FetchType.LAZY)
    private List<FornecedorEndereco> fornecedorEnderecos;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "fornecedorContato",
            fetch = FetchType.LAZY)
    private List<FornecedorContato> fornecedorContatos;

    public Fornecedor() {
    }

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<FornecedorEndereco> getFornecedorEnderecos() {
        return fornecedorEnderecos;
    }

    public void setFornecedorEnderecos(List<FornecedorEndereco> fornecedorEnderecos) {
        this.fornecedorEnderecos = fornecedorEnderecos;
    }

    public List<FornecedorContato> getFornecedorContatos() {
        return fornecedorContatos;
    }

    public void setFornecedorContatos(List<FornecedorContato> fornecedorContatos) {
        this.fornecedorContatos = fornecedorContatos;
    }
}
