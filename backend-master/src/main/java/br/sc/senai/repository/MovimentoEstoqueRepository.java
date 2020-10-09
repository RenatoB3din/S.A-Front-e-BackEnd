package br.sc.senai.repository;

import br.sc.senai.model.EMovimentaEstoque;
import br.sc.senai.model.MovimentoEstoque;
import br.sc.senai.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Optional;

public interface MovimentoEstoqueRepository extends CrudRepository<MovimentoEstoque, Integer> {
    @Query(value = "SELECT m FROM MovimentoEstoque m WHERE m.nrNotaFiscal = :nrnf")
    Optional<MovimentoEstoque> findByNrNF(@Param("nrnf") String nrNotaFiscal);
}
