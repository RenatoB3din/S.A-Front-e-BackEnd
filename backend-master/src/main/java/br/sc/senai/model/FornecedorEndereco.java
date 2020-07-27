package br.sc.senai.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cadfornecendereco")
public class FornecedorEndereco extends Endereco{

    @Column(name = "tipo_endereco")
    private EEndereco tipoEndereco;

    // TODO: 25/07/2020 >>> criar uma forma de incluir apenas o id do fornecedor sem necessidade da tabela de relação
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_fornecedor")
//    private Fornecedor fornecedor;


    public FornecedorEndereco(){
        super();
    }

    public FornecedorEndereco(Integer id, String cep, String logradouro, String complemento, String outroComplemento, String bairro, String localidade, String uf) {
        super(id, cep, logradouro, complemento, outroComplemento, bairro, localidade, uf);
    }

    public EEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(EEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

}
