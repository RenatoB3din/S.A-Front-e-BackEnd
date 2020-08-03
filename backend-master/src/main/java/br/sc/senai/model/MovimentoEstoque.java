package br.sc.senai.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "momento_estoque")
public class MovimentoEstoque {

    @Id
    @Column(name = "id_movimento_estoque")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMovimentoEstoque;

    @ManyToOne
    @JoinColumn(name = "id_fornecedor")
    private Fornecedor fornecedor;

    @Column(name = "nr_notafiscal")
    @Size(max = 15)
    private String nrNotaFiscal;

    @Column(name = "dt_notafiscal")
    @Size(max = 10)
    private String dataNotaFiscal;

    @Column(name = "img_notafiscal")
    private String imgNotaFiscal;

    @Enumerated(value = EnumType.STRING)
    private EMovimentaEstoque tipoMovimento;

    @OneToMany(mappedBy = "movimentoEstoque")
    private Set<MovimentoEstoqueItem> movimentoEstoqueItem;

    public MovimentoEstoque() {
    }

    public MovimentoEstoque(Fornecedor fornecedor, String nrNotaFiscal, String dataNotaFiscal, String imgNotaFiscal, EMovimentaEstoque tipoMovimento){
        this.fornecedor = fornecedor;
        this.nrNotaFiscal = nrNotaFiscal;
        this.dataNotaFiscal = dataNotaFiscal;
        this.imgNotaFiscal = imgNotaFiscal;
        this.tipoMovimento = tipoMovimento;
    }

    public Integer getIdMovimentoEstoque() {
        return idMovimentoEstoque;
    }

    public void setIdMovimentoEstoque(Integer idMovimentoEstoque) {
        this.idMovimentoEstoque = idMovimentoEstoque;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getNrNotaFiscal() {
        return nrNotaFiscal;
    }

    public void setNrNotaFiscal(String nrNotaFiscal) {
        this.nrNotaFiscal = nrNotaFiscal;
    }

    public String getDataNotaFiscal() {
        return dataNotaFiscal;
    }

    public void setDataNotaFiscal(String dataNotaFiscal) {
        this.dataNotaFiscal = dataNotaFiscal;
    }

    public String getImgNotaFiscal() {
        return imgNotaFiscal;
    }

    public void setImgNotaFiscal(String imgNotaFiscal) {
        this.imgNotaFiscal = imgNotaFiscal;
    }

    public EMovimentaEstoque getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(EMovimentaEstoque tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public Set<MovimentoEstoqueItem> getMovimentoEstoqueItem() {
        return movimentoEstoqueItem;
    }

    public void setMovimentoEstoqueItem(Set<MovimentoEstoqueItem> movimentoEstoqueItem) {
        this.movimentoEstoqueItem = movimentoEstoqueItem;
    }

}
