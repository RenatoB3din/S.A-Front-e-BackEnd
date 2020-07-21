package br.sc.senai.repository;

import br.sc.senai.model.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

//    @Query(value = "SELECT p FROM Produto p WHERE " +
//            "p.nomeProduto LIKE CONCAT('%',:nomeProduto,'%') OR " +
//            "p.descricaoProduto LIKE CONCAT('%',:nomeProduto,'%')")
//    Collection<Produto> findByProduto(@Param("nomeProduto") String nomeProduto);
//
    @Query(value = "SELECT p FROM Produto p WHERE p.idProduto = :idProduto")
    Collection<Produto> findByCodigoProduto(@Param("idProduto") Integer idProduto);

//    @Query(value = "SELECT p FROM Produto p WHERE p.codBarras = :codBarras")
//    Collection<Produto> findByCodigoBarras(@Param("codBarras") String codBarras);
}
