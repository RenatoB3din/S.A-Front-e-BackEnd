package br.sc.senai.controller;

import br.sc.senai.model.Fornecedor;
import br.sc.senai.model.MovimentoEstoque;
import br.sc.senai.repository.FornecedorRepository;
import br.sc.senai.repository.MovimentoEstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/stockMovement")
public class MovimentoEstoqueController {

    @Autowired
    private MovimentoEstoqueRepository movimentoEstoqueRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;


    @GetMapping("/register")
    public @ResponseBody
    ResponseEntity<Iterable<MovimentoEstoque>> getMovements() {
        try {
            Iterable<MovimentoEstoque> movimentos = movimentoEstoqueRepository.findAll();
            if (((Collection<?>) movimentos).size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(movimentos, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/register/provider/{idProvider}")
    public @ResponseBody
    ResponseEntity<MovimentoEstoque> addMovimentoEsoque(@PathVariable("idProvider") Integer idFornecedor,
                                                        @RequestBody MovimentoEstoque movimentoEstoque){

        try{

            Optional<Fornecedor> fornecedorData = fornecedorRepository.findById(idFornecedor);


            if (fornecedorData.isPresent()){
                MovimentoEstoque novoMovimento = new MovimentoEstoque();
                novoMovimento.setNrNotaFiscal(movimentoEstoque.getNrNotaFiscal());
                novoMovimento.setTipoMovimento(movimentoEstoque.getTipoMovimento());
                novoMovimento.setDataNotaFiscal(movimentoEstoque.getDataNotaFiscal());
                novoMovimento.setImagemURL(movimentoEstoque.getImagemURL());
                novoMovimento.setFornecedor(fornecedorData.get());

                movimentoEstoqueRepository.save(novoMovimento);

                return new ResponseEntity<>(novoMovimento, HttpStatus.CREATED);
            }else {

                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }

        }catch (Exception e){

            System.out.println(e.getMessage());

            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);

        }

    }
}
