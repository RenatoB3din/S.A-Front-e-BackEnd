package br.sc.senai.model;

import javax.persistence.*;

@Entity
@Table(name = "fornecedor_contato")
public class FornecedorContato {

    @Id
    @Column(name = "id_fornecedor_contato")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idFornecedorContato;

    @Column(name = "nome_contato", length = 100)
    private String nomeContato;

    @Column(name = "nr_telefone", length = 11)
    private String nrTelefone;

    @Column(name = "email_contato")
    private String emailContato;

    // TODO: 08/07/2020 >> Fazer ManyToOne com fornecedor
    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedorContato;

    public FornecedorContato() {
    }

    public Integer getIdFornecedorContato() {
        return idFornecedorContato;
    }

    public void setIdFornecedorContato(Integer idFornecedorContato) {
        this.idFornecedorContato = idFornecedorContato;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getNrTelefone() {
        return nrTelefone;
    }

    public void setNrTelefone(String nrTelefone) {
        this.nrTelefone = nrTelefone;
    }

    public String getEmailContato() {
        return emailContato;
    }

    public void setEmailContato(String emailContato) {
        this.emailContato = emailContato;
    }

    public Fornecedor getFornecedorContato() {
        return fornecedorContato;
    }

    public void setFornecedorContato(Fornecedor fornecedorContato) {
        this.fornecedorContato = fornecedorContato;
    }
}
