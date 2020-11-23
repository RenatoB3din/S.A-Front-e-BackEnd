package br.sc.senai.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "movimento_estoque",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "nrNotaFiscal"),
        })
public class MovimentoEstoque {

    @Id
    @Column(name = "id_movimento_estoque")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMovimentoEstoque;

    @ManyToOne
    @JoinColumn(name = "id_fornecedor")
    @JsonIgnore
    private Fornecedor fornecedor;

    @NotBlank
    @Size(max = 15)
    private String nrNotaFiscal;

    @NotBlank
    @Column(name = "dt_notafiscal")
    @Size(max = 10)
    private String dataNotaFiscal;

    @Column(name = "img_notafiscal")
    private String imagemURL;

    @Enumerated(value = EnumType.STRING)
    private EMovimentaEstoque tipoMovimento;


    @OneToMany(mappedBy = "movimentoEstoque")
    @JsonIgnore
    private Set<MovimentoEstoqueItem> movimentoEstoqueItem;

    public MovimentoEstoque() {
    }

    public MovimentoEstoque(Fornecedor fornecedor, String nrNotaFiscal, String dataNotaFiscal, String imagemURL, EMovimentaEstoque tipoMovimento){
        this.fornecedor = fornecedor;
        this.nrNotaFiscal = nrNotaFiscal;
        this.dataNotaFiscal = dataNotaFiscal;
        this.imagemURL = imagemURL;
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

    public String getImagemURL() {
        return imagemURL;
    }

    public void setImagemURL(String imagemURL) {
        this.imagemURL = imagemURL;
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
