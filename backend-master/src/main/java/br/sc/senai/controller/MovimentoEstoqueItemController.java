package br.sc.senai.controller;

import br.sc.senai.model.MovimentoEstoqueItem;
import br.sc.senai.repository.MovimentoEstoqueItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/stockmoviment/product")
public class MovimentoEstoqueItemController {

    @Autowired
    private MovimentoEstoqueItemRepository movimentoEstoqueItemRepository;

    @PostMapping(path = "/register")
    public @ResponseBody
    ResponseEntity<MovimentoEstoqueItem> addMovimentoEstoqueItem(@RequestBody MovimentoEstoqueItem movimentoEstoqueItem){

        try{

            MovimentoEstoqueItem novoMovimentoEsoqueItem = movimentoEstoqueItemRepository.save(movimentoEstoqueItem);

            return new ResponseEntity<MovimentoEstoqueItem>(novoMovimentoEsoqueItem, HttpStatus.EXPECTATION_FAILED);

        }catch (Exception e){

            System.out.println(e.getMessage());

            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);

        }

    }

}
