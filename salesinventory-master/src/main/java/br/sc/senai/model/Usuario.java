package br.sc.senai.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Column(name = "nome_completo", length = 100 )
    @NotNull
    private String nomeCompleto;

    @Column(length = 50)
    @NotNull
    private String login;

    // TODO: 15/07/2020 >> CRIPTOGRAFAR A SENHA 
    @Column(length = 50)
    @NotNull
    private String senha;
    
    @Column(length = 150)
    @NotNull
    private String email;

    @Column(length = 11)
    @NotNull
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "idPerfil")
    private Perfil perfil;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}
