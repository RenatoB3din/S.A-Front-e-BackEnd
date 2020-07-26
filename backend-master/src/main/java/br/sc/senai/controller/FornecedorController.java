package br.sc.senai.controller;


import br.sc.senai.model.Fornecedor;
import br.sc.senai.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/provider")
public class FornecedorController {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @PostMapping(path = "/register")
    public @ResponseBody
    ResponseEntity<Fornecedor> addFornecedor(@RequestBody Fornecedor fornecedor){

        try{

            Fornecedor novoFornecedor = fornecedorRepository.save(fornecedor);

            return new ResponseEntity<>(novoFornecedor, HttpStatus.CREATED);

        }catch (Exception e){

            System.out.println(e.getMessage());

            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping(path = "/register/{idFornecedor}")
    public @ResponseBody
    ResponseEntity<Fornecedor> editFornecedor(@PathVariable("idFornecedor") Integer idFornecedor,
                                              @RequestBody Fornecedor fornecedor){

        //LOCALIZAR O FORNECEDOR
        Optional<Fornecedor> fornecedorData = fornecedorRepository.findById(idFornecedor);

        try {

            if(fornecedorData.isPresent()){

                Fornecedor editFornecedor = fornecedorData.get();
                editFornecedor.setNomeFantasia(fornecedor.getNomeFantasia());
                editFornecedor.setRazaoSocial(fornecedor.getRazaoSocial());
                editFornecedor.setCnpj(fornecedor.getCnpj());
                editFornecedor.setNomeContato(fornecedor.getNomeContato());
                editFornecedor.setTelefone(fornecedor.getTelefone());
                editFornecedor.setEmail(fornecedor.getEmail());

                return new ResponseEntity<>(fornecedorRepository.save(editFornecedor), HttpStatus.OK);

            } else {

                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }

        } catch (Exception e){

            return new ResponseEntity<>(fornecedor, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/register/{idFornecedor}")
    public @ResponseBody
    ResponseEntity<HttpStatus> deleteFornecedor(@PathVariable("idFornecedor") Integer idFornecedor){

        try{

            fornecedorRepository.deleteById(idFornecedor);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }catch (Exception e){

            System.out.println(e.getMessage());

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }
}
