package br.sc.senai.controller;

import br.sc.senai.model.Produto;
import br.sc.senai.repository.ProdutoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProdutoController {

    @Autowired
    private ProdutoRespository produtoRespository;

    @PostMapping("/register")
    public @ResponseBody
    ResponseEntity<Produto> addProduto(@RequestBody Produto produto){

        try{

            Produto novoProduto = produtoRespository.save(produto);

            return new ResponseEntity<>(novoProduto, HttpStatus.CREATED);

        }catch (Exception e){

            System.out.println(e.getMessage());

            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);

        }
    }

    @PutMapping("/register/{idProduto}")
    public @ResponseBody
    ResponseEntity<Produto> editPorduto(@PathVariable("idProduto") Integer idProduto,
                                        @RequestBody Produto produto){

        Optional<Produto> produtoData = produtoRespository.findById(idProduto);

        try{
            if (produtoData.isPresent()){

                Produto editProduto = produtoData.get();
                editProduto.setNomeProduto(produto.getNomeProduto());
                editProduto.setDescricaoProduto(produto.getDescricaoProduto());
                editProduto.setCodBarras(produto.getCodBarras());
                editProduto.setPercentualSobreVenda(produto.getPercentualSobreVenda());
                editProduto.setImagemURL(produto.getImagemURL());

                return new ResponseEntity<>(produtoRespository.save(editProduto), HttpStatus.OK);

            }else{

                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

            }


        }catch (Exception e){

            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);

        }
    }

    @DeleteMapping("/register/{idProduto}")
    public @ResponseBody
    ResponseEntity<HttpStatus> deleteProduto(@PathVariable("idProduto") Integer idProduto){

        try {

            produtoRespository.deleteById(idProduto);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }catch (Exception e){

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

}
