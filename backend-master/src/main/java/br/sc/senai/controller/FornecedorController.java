package br.sc.senai.controller;

import br.sc.senai.model.Fornecedor;
import br.sc.senai.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/provider")
public class FornecedorController {
    
    @Autowired
    private FornecedorRepository fornecedorRepository;
    
    @PostMapping(path = "/add")
    public @ResponseBody
    ResponseEntity<Fornecedor> addFornecedor(@RequestBody Fornecedor fornecedor){
        try{
            Fornecedor newFornecedor = fornecedorRepository.save(fornecedor);
            return new ResponseEntity<>(newFornecedor, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    // TODO: 23/07/2020 >> Fazer os demais CRUD (Alteração e Exclusão) 

    // TODO: 23/07/2020 >> Tratar erros 
    
}
