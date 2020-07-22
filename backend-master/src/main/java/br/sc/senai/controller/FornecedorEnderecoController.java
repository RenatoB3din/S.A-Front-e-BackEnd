package br.sc.senai.controller;

import br.sc.senai.model.FornecedorEndereco;
import br.sc.senai.repository.FornecedorEnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/fonecedorEndereco")
public class FornecedorEnderecoController {

    @Autowired
    private FornecedorEnderecoRepository fornecedorEnderecoRepository;

    @PostMapping(path = "/cadastrar")
    public @ResponseBody
    ResponseEntity<FornecedorEndereco> salvarFornecedorEndereco(FornecedorEndereco fornecedorEndereco){
        try{
            FornecedorEndereco newEndereco = fornecedorEnderecoRepository.save(fornecedorEndereco);
            return new ResponseEntity<FornecedorEndereco>(newEndereco, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }
}
