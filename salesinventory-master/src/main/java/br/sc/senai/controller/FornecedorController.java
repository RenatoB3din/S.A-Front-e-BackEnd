package br.sc.senai.controller;

import br.sc.senai.model.Fornecedor;
import br.sc.senai.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @PostMapping(path = "/cadastrar")
    public @ResponseBody
    ResponseEntity<Fornecedor> adicionarFornecedor(@RequestBody Fornecedor fornecedor){
        try{
            Fornecedor novoFornecedor = fornecedorRepository.save(fornecedor);
            return new ResponseEntity<Fornecedor>(fornecedor, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }
}