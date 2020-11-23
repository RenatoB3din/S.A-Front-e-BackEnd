package br.sc.senai.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "venda",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "nrCupomFiscal"),
        })
public class Venda {

    @Id
    @Column(name = "id_venda")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVenda;

    @NotBlank
    @Size(max = 15)
    private String nrCupomFiscal;

    @NotBlank
    @Column(name = "dt_venda")
    @Size(max = 10)
    private String dataVenda;

    @NotBlank
    @Column(name= "nome_cliente_venda")
    @Size(max = 75)
    private String nomeCliente;

    @NotBlank
    @Column(name= "cpf_cnpj_venda")
    @Size(max = 18)
    private String cpfCnpj;

    @NotBlank
    @Column(name= "nome_vendedor_venda")
    @Size(max = 75)
    private String nomeVendedor;


    @Enumerated(value = EnumType.STRING)
    private EMovimentaEstoque tipoMovimento;


    @Enumerated(value = EnumType.STRING)
    private ETipoPagamento tipoPagamento;

    @OneToMany(mappedBy = "venda")
    @JsonIgnore
    private Set<VendaItem> vendaItem;

    public Venda(){

    }

    public Venda(Integer idVenda, String dataVenda, String nrCupomFiscal, String nomeCliente, String cpfCnpj, String nomeVendedor, EMovimentaEstoque tipoMovimento, ETipoPagamento tipoPagamento) {
        this.idVenda = idVenda;
        this.dataVenda = dataVenda;
        this.nomeCliente = nomeCliente;
        this.cpfCnpj = cpfCnpj;
        this.nomeVendedor = nomeVendedor;
        this.tipoMovimento = tipoMovimento;
        this.tipoPagamento = tipoPagamento;
        this.nrCupomFiscal = nrCupomFiscal;
    }

    public Integer getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Integer idVenda) {
        this.idVenda = idVenda;
    }

    public String getNrCupomFiscal() {
        return nrCupomFiscal;
    }

    public void setNrCupomFiscal(String nrCupomFiscal) {
        this.nrCupomFiscal = nrCupomFiscal;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
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

    public EMovimentaEstoque getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(EMovimentaEstoque tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public ETipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(ETipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public Set<VendaItem> getVendaItem() {
        return vendaItem;
    }

    public void setVendaItem(Set<VendaItem> vendaItem) {
        this.vendaItem = vendaItem;
    }
}
