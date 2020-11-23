package br.sc.senai.controller;

import br.sc.senai.model.Fornecedor;
import br.sc.senai.model.MovimentoEstoque;
import br.sc.senai.model.Venda;
import br.sc.senai.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/sales")
public class VendaController {

    @Autowired
    private VendaRepository vendaRepository;

    @PostMapping(path = "/register")
    public @ResponseBody
    ResponseEntity<Venda> addVenda(@RequestBody Venda venda){

        try{

            Venda novaVenda = new Venda();
            novaVenda.setDataVenda(venda.getDataVenda());
            novaVenda.setNomeCliente(venda.getNomeCliente());
            novaVenda.setCpfCnpj(venda.getCpfCnpj());
            novaVenda.setNomeVendedor(venda.getNomeVendedor());
            novaVenda.setTipoMovimento(venda.getTipoMovimento());
            novaVenda.setNrCupomFiscal(venda.getNrCupomFiscal());
            novaVenda.setTipoPagamento(venda.getTipoPagamento());

            vendaRepository.save(novaVenda);

            return new ResponseEntity<>(novaVenda, HttpStatus.CREATED);

        }catch (Exception e){

            System.out.println(e.getMessage());

            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);

        }

    }

}
