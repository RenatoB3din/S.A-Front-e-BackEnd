package br.sc.senai.model;

import javax.persistence.*;

@Entity
@Table(name = "fornecedor_endereco")
public class FornecedorEndereco {

    // TODO: 08/07/2020 >> Evoluir para uma classe de reuso geral

    @Id
    @Column(name = "id_fornecedor_endereco")
    private Integer idForncedorEndereco;

    @Column(name = "tipo_endereco", columnDefinition = "varchar(20) default 'COMERCIAL'")
    private String tipoEndereco;

    @Column(length = 8)
    private String cep;

    private String rua;

    @Column(length = 6)
    private String numero;

    @Column(length = 50)
    private String complemento;

    private String bairro;

    private String municipio;

    @Column(length = 2)
    private String uf;

    @Column(length = 150)
    private String referencia;

    // TODO: 08/07/2020 >> Fazer ManyToOne com fornecedor.
    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedorEndereco;

    public FornecedorEndereco() {
    }

    public Integer getIdForncedorEndereco() {
        return idForncedorEndereco;
    }

    public void setIdForncedorEndereco(Integer idForncedorEndereco) {
        this.idForncedorEndereco = idForncedorEndereco;
    }

    public String getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(String tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Fornecedor getFornecedorEndereco() {
        return fornecedorEndereco;
    }

    public void setFornecedorEndereco(Fornecedor fornecedorEndereco) {
        this.fornecedorEndereco = fornecedorEndereco;
    }
}
