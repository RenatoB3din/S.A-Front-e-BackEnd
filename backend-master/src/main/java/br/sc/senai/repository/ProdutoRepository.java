package br.sc.senai.repository;

import br.sc.senai.model.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

    @Query(value = "SELECT p FROM Produto p WHERE p.nomeProduto = :nomeProduto")
    Collection<Produto> findAllByName(@Param("nomeProduto") String nomeProduto);

    @Query(value = "SELECT p FROM Produto p WHERE p.idProduto = :idProduto")
    Collection<Produto> findAllByCodigoProduto(@Param("idProduto") Integer idProduto);

    @Query(value = "SELECT p FROM Produto p WHERE p.codBarras LIKE CONCAT('%',:codBarras,'%')")
    Collection<Produto> findAllByCodigoBarras(@Param("codBarras") String codBarras);
}
