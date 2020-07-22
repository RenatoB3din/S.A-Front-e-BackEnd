//package br.sc.senai.controller;
//
//import br.sc.senai.model.Produto;
//import br.sc.senai.model.Usuario;
//import br.sc.senai.repository.ProdutoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.websocket.server.PathParam;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.Optional;
//
//@RestController
//@CrossOrigin
//@RequestMapping(path = "/produto")
//public class ProdutoController {
//
//    @Autowired
//    private ProdutoRepository produtoRepository;
//
//    @PostMapping(path = "/cadastrar")
//    public @ResponseBody
//    ResponseEntity<Produto> cadastrarProduto(@RequestBody Produto produto){
//        try{
//            Produto novoProduto = produtoRepository.save(produto);
//
//            return new ResponseEntity<Produto>(novoProduto, HttpStatus.CREATED);
//        }catch (Exception e){
//            return new ResponseEntity<>(null, HttpStatus.CREATED);
//        }
//    }
//
//    @PutMapping(path = "/editar/{id}")
//    public @ResponseBody ResponseEntity<Produto> editarProduto(@PathVariable("id") Integer idProduto,
//                                                               @RequestBody Produto produto){
//
//        Optional<Produto> produtoData = produtoRepository.findById(idProduto);
//
//        try{
//            if(produtoData.isPresent()){
//                Produto editarProduto = produtoData.get();
//                editarProduto.setNomeProduto(produto.getNomeProduto());
//                editarProduto.setDescricaoProduto(produto.getDescricaoProduto());
//                editarProduto.setCodBarras(produto.getCodBarras());
//                editarProduto.setUnidade(produto.getUnidade());
//                editarProduto.setPercentualSobreVenda(produto.getPercentualSobreVenda());
//                editarProduto.setImagemURL(produto.getImagemURL());
//                return new ResponseEntity<>(produtoRepository.save(editarProduto), HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            }
//        }catch(Exception e){
//            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
//        }
//    }
//
//    @DeleteMapping(path = "/excluir/{id}")
//    public @ResponseBody ResponseEntity<HttpStatus> removerProduto(@PathVariable ("id") Integer idProduto){
//        try {
//            produtoRepository.deleteById(idProduto);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
//        }
//    }
//
//    //PESQUISA DE PRODUTO
//    @GetMapping(path = "/")
//    public @ResponseBody ResponseEntity<Iterable<Produto>> getAllProdutos(){
//        try {
//            Iterable<Produto> produtos = produtoRepository.findAll();
//            if(((Collection<?>) produtos).size() == 0){
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(produtos, HttpStatus.OK);
//        } catch (Exception e){
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PostMapping(path = "/nomeProduto/{nome}")
//    public @ResponseBody ResponseEntity<Iterable<Produto>> findByName(@PathVariable("nome") String nome,
//                                                                      @RequestBody Usuario usuario) {
//        try {
//            Iterable<Produto> produtos = produtoRepository.findAllByName(nome);
//            if(((Collection<?>) produtos).size() == 0){
//
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(produtos, HttpStatus.OK);
//        }catch (Exception e){
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//}
