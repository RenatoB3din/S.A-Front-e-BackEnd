package br.sc.senai.controller;

import br.sc.senai.model.FornecedorContato;
import br.sc.senai.repository.FornecedorContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/fornecedorContato")
public class FornecedorContatoController {

    @Autowired
    private FornecedorContatoRepository fornecedorContatoRepository;

    @PostMapping(path = "/cadastrar")
    public @ResponseBody
    ResponseEntity<FornecedorContato> salvarFornecedorContato(@RequestBody FornecedorContato fornecedorContato){
        try{
            FornecedorContato novoContato = fornecedorContatoRepository.save(fornecedorContato);
            return new ResponseEntity<FornecedorContato>(novoContato, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }
}
