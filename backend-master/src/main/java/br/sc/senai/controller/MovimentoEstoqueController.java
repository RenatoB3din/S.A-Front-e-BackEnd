package br.sc.senai.controller;

import br.sc.senai.model.MovimentoEstoque;
import br.sc.senai.repository.MovimentoEstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/stockMovement")
public class MovimentoEstoqueController {

    @Autowired
    private MovimentoEstoqueRepository movimentoEstoqueRepository;

    @PostMapping(path = "/register")
    public @ResponseBody
    ResponseEntity<MovimentoEstoque> addMovimentoEsoque(@RequestBody MovimentoEstoque movimentoEstoque){

        try{

            MovimentoEstoque novoMovimentoEsoque = movimentoEstoqueRepository.save(movimentoEstoque);

            return new ResponseEntity<MovimentoEstoque>(novoMovimentoEsoque, HttpStatus.CREATED);

        }catch (Exception e){

            System.out.println(e.getMessage());

            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);

        }

    }
}
