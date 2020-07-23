package br.sc.senai.controller;

import br.sc.senai.model.Endereco;
import br.sc.senai.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/adress")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    ResponseEntity<Endereco> addEndereco(@RequestBody Endereco endereco){
        try{
            Endereco newEndereco = enderecoRepository.save(endereco);
            return new ResponseEntity<>(newEndereco, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    // TODO: 23/07/2020 >> Fazer os demais CRUD (Alteração e Exclusão)

    // TODO: 23/07/2020 >> Tratar erros
}
