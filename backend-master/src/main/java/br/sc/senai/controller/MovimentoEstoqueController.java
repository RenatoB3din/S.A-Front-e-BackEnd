package br.sc.senai.controller;

import br.sc.senai.model.Fornecedor;
import br.sc.senai.model.MovimentoEstoque;
import br.sc.senai.repository.FornecedorEnderecoRespoistory;
import br.sc.senai.repository.FornecedorRepository;
import br.sc.senai.repository.MovimentoEstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/stockMovement")
public class MovimentoEstoqueController {

    @Autowired
    private MovimentoEstoqueRepository movimentoEstoqueRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

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
                novoMovimento.setImgNotaFiscal(movimentoEstoque.getImgNotaFiscal());
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
