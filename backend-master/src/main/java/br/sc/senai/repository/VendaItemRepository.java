package br.sc.senai.repository;

import br.sc.senai.model.VendaItem;
import org.springframework.data.repository.CrudRepository;

public interface VendaItemRepository extends CrudRepository<VendaItem, Integer> {
}
