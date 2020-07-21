package br.sc.senai.repository;

import br.sc.senai.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    @Query(value = "SELECT u FROM Usuario u WHERE u.nomeCompleto LIKE CONCAT('%',:nomeCompleto,'%')")
    Collection<Usuario> findAllByName(@Param("nomeCompleto") String nomeCompleto);

    @Query(value = "SELECT u FROM Usuario u WHERE u.cpf LIKE CONCAT('%',:cpf,'%')")
    Collection<Usuario> findByCPF(@Param("cpf") String cpf);

}
