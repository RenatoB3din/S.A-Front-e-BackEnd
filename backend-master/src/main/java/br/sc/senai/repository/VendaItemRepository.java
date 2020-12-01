package br.sc.senai.repository;

import br.sc.senai.model.Venda;
import br.sc.senai.model.VendaItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface VendaItemRepository extends CrudRepository<VendaItem, Integer> {
}
