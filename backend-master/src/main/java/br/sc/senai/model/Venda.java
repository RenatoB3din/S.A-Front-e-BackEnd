package br.sc.senai.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "venda")
public class Venda {

    @Id
    @Column(name = "id_venda")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVenda;

    @Column(name = "nr_cupomfiscal")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nrCupomFiscal;

    @Column(name = "dt_venda")
    @Size(max = 10)
    private String dataVenda;

    @Column(name= "nome_cliente")
    @Size(max = 75)
    private String nomeCliente;

    @Column(name= "cpf_cnpj")
    @Size(max = 18)
    private String cpfCnpj;

    @Column(name= "nome_vendedor")
    @Size(max = 75)
    private String nomeVendedor;

    @Enumerated(value = EnumType.STRING)
    private EMovimentaEstoque tipoMovimento;

    @OneToMany(mappedBy = "venda")
    @JsonIgnore
    private Set<VendaItem> vendaItem;

    public Venda(){

    }

    public Venda(Integer idVenda, String dataVenda, String nomeCliente, String cpfCnpj, String nomeVendedor, EMovimentaEstoque tipoMovimento) {
        this.idVenda = idVenda;
        this.dataVenda = dataVenda;
        this.nomeCliente = nomeCliente;
        this.cpfCnpj = cpfCnpj;
        this.nomeVendedor = nomeVendedor;
        this.tipoMovimento = tipoMovimento;
    }

    public Integer getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Integer idVenda) {
        this.idVenda = idVenda;
    }

    public Integer getNrCupomFiscal() {
        return nrCupomFiscal;
    }

    public void setNrCupomFiscal(Integer nrCupomFiscal) {
        this.nrCupomFiscal = nrCupomFiscal;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public EMovimentaEstoque getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(EMovimentaEstoque tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public Set<VendaItem> getVendaItem() {
        return vendaItem;
    }

    public void setVendaItem(Set<VendaItem> vendaItem) {
        this.vendaItem = vendaItem;
    }
}
