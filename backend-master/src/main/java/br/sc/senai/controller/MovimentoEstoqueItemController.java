package br.sc.senai.controller;

import br.sc.senai.model.MovimentoEstoque;
import br.sc.senai.model.MovimentoEstoqueItem;
import br.sc.senai.model.Produto;
import br.sc.senai.payload.response.JwtResponse;
import br.sc.senai.repository.MovimentoEstoqueItemRepository;
import br.sc.senai.repository.MovimentoEstoqueRepository;
import br.sc.senai.repository.ProdutoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/stockMoviment")
public class MovimentoEstoqueItemController {

    @Autowired
    private MovimentoEstoqueItemRepository movimentoEstoqueItemRepository;

    @Autowired
    private MovimentoEstoqueRepository movimentoEstoqueRepository;

    @Autowired
    private ProdutoRespository produtoRespository;

    @PostMapping(path = "/register/moviment/{idMoviment}/product/{idProduct}")
    public @ResponseBody
    ResponseEntity<MovimentoEstoqueItem> addMovimentoEstoqueItem(@PathVariable("idMoviment") String nrNotaFiscal,
                                                                 @PathVariable("idProduct") Integer idProduto,
                                                                 @RequestBody MovimentoEstoqueItem movimentoEstoqueItem){


        System.out.println(nrNotaFiscal);
        System.out.println(idProduto);

        try{

            Optional<MovimentoEstoque> movimentoEstoqueData = movimentoEstoqueRepository.findByNrNF(nrNotaFiscal);
            Optional<Produto> produtoData = produtoRespository.findById(idProduto);

            Enum tipoMovimento = movimentoEstoqueData.get().getTipoMovimento();

            if (movimentoEstoqueData.isPresent() && produtoData.isPresent()){

                MovimentoEstoqueItem novoItem = new MovimentoEstoqueItem();
                novoItem.setMovimentoEstoque(movimentoEstoqueData.get());
                novoItem.setProduto(produtoData.get());
                novoItem.setQtde(movimentoEstoqueItem.getQtde());
                novoItem.setValor(movimentoEstoqueItem.getValor());
                novoItem.setValidade(movimentoEstoqueItem.getValidade());
                novoItem.setLote(movimentoEstoqueItem.getLote());

                produtoData.get().atualizaQuantidadeEstoque(movimentoEstoqueItem.getQtde(), tipoMovimento);
                produtoData.get().setValorCompra(movimentoEstoqueItem.getValor());
                produtoData.get().atualizaValorVenda(movimentoEstoqueItem.getValor(),produtoData.get().getPercentualSobreVenda());

                movimentoEstoqueItemRepository.save(novoItem);

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
