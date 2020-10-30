package br.sc.senai.controller;

import br.sc.senai.model.*;
import br.sc.senai.repository.ProdutoRespository;
import br.sc.senai.repository.VendaItemRepository;
import br.sc.senai.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/salesItem")
public class VendaItemController {

    @Autowired
    private VendaItemRepository vendaItemRepository;

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ProdutoRespository produtoRespository;

    @PostMapping(path = "/register/sales/{idSales}/product/{idProduct}")
    public @ResponseBody
    ResponseEntity<VendaItem> addVendaItem(@PathVariable("idSales") Integer idSales,
                                           @PathVariable("idProduct") Integer idProduto,
                                           @RequestBody VendaItem vendaItem){


        System.out.println(idSales);
        System.out.println(idProduto);

        try{

            Optional<Venda> vendaData = vendaRepository.findById(idSales);
            Optional<Produto> produtoData = produtoRespository.findById(idProduto);

            Enum tipoMovimento = vendaData.get().getTipoMovimento();

            if (vendaData.isPresent() && produtoData.isPresent()){

                VendaItem novoItem = new VendaItem();
                novoItem.setVenda(vendaData.get());
                novoItem.setProduto(produtoData.get());
                novoItem.setQtde(vendaItem.getQtde());
                novoItem.setValorUntario(vendaItem.getValorUntario());
                novoItem.setValorTotalBruto(vendaItem.getValorTotalBruto());
                novoItem.setValorDesconto(vendaItem.getValorDesconto());
                novoItem.setValorTotal(vendaItem.getValorTotalBruto() - vendaItem.getValorDesconto());

                produtoData.get().atualizaQuantidadeEstoque(vendaItem.getQtde(), tipoMovimento);
                produtoData.get().atualizaValorVenda(vendaItem.getValorUntario());

                vendaItemRepository.save(novoItem);

                return new ResponseEntity<>(novoItem, HttpStatus.CREATED);

            } else {

                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        }catch (Exception e){

            System.out.println(e.getMessage());

            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);

        }

    }
}
