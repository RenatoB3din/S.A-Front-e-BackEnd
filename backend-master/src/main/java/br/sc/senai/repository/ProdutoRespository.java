package br.sc.senai.repository;


import br.sc.senai.model.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRespository extends CrudRepository<Produto, Integer> {
}
