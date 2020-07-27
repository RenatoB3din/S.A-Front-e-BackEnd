package br.sc.senai.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cep;
    private String logradouro;
    private String complemento;
    private String outroComplemento;
    private String bairro;
    private String localidade;
    private String uf;


    public Endereco(String cep, String logradouro, String complemento, String outroComplemento, String bairro, String municipio, String uf){}

    public Endereco(Integer id, String cep, String logradouro, String complemento, String outroComplemento, String bairro, String localidade, String uf) {
        this.id = id;
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.outroComplemento = outroComplemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
    }

    public Endereco() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
