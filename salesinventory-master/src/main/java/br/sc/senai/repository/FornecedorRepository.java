package br.sc.senai.repository;

import br.sc.senai.model.Fornecedor;
import org.springframework.data.repository.CrudRepository;

public interface FornecedorRepository extends CrudRepository<Fornecedor, Integer> {
}
