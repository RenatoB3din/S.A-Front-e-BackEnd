package br.sc.senai.model;

import javax.persistence.*;

@Entity
@Table(name = "fornecedor_endereco")
public class FornecedorEndereco extends Endereco{

    @Enumerated(value = EnumType.STRING)
    @Column(name = "tipo_endereco")
    private EEndereco tipoEndereco;

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
