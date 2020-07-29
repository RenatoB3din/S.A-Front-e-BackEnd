package br.sc.senai.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "momentoestoque")
public class MovimentoEstoque {

    @Id
    @Column(name = "id_movimentoestoque")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMovimentoEstoque;

    @Column(name = "id_fonecedor")
    private Integer idFornecedor;

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

    public MovimentoEstoque(Integer idFornecedor, String nrNotaFiscal, String dataNotaFiscal, String imgNotaFiscal, EMovimentaEstoque tipoMovimento){
        this.idFornecedor = idFornecedor;
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

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
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
