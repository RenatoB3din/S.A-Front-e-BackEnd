package br.sc.senai.controller;

import br.sc.senai.model.FornecedorEndereco;
import br.sc.senai.repository.FornecedorEnderecoRespoistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/provider/adress")
public class FornecedorEnderecoController {

    @Autowired
    public FornecedorEnderecoRespoistory fornecedorEnderecoRespoistory;

    @PostMapping("/resgister")
    public @ResponseBody
    ResponseEntity<FornecedorEndereco> addFornecedorEndereco(FornecedorEndereco fornecedorEndereco){
        try{
            FornecedorEndereco novoFornecedorEndereco = fornecedorEnderecoRespoistory.save(fornecedorEndereco);
            return new ResponseEntity<>(novoFornecedorEndereco, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/register/{idEndereco}")
    public @ResponseBody
    ResponseEntity<FornecedorEndereco> editFornecedorEndereco(@PathVariable("idEndereco") Integer idEndereco,
                                                              @RequestBody FornecedorEndereco fornecedorEndereco){
        Optional<FornecedorEndereco> enderecoData = fornecedorEnderecoRespoistory.findById(idEndereco);

        try{
            if (enderecoData.isPresent()){
                FornecedorEndereco editFornecedorEndereco = enderecoData.get();
                editFornecedorEndereco.setCep(fornecedorEndereco.getCep());
                editFornecedorEndereco.setRua(fornecedorEndereco.getRua());
                editFornecedorEndereco.setNumero(fornecedorEndereco.getNumero());
                editFornecedorEndereco.setComplemento(fornecedorEndereco.getComplemento());
                editFornecedorEndereco.setBairro(fornecedorEndereco.getBairro());
                editFornecedorEndereco.setMunicipio(fornecedorEndereco.getMunicipio());
                editFornecedorEndereco.setUf(fornecedorEndereco.getUf());
                editFornecedorEndereco.setTipoEndereco(fornecedorEndereco.getTipoEndereco());

                return new ResponseEntity<>(fornecedorEnderecoRespoistory.save(editFornecedorEndereco), HttpStatus.OK);


            } else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/register/{idEndereco}")
    public @ResponseBody
    ResponseEntity<HttpStatus> delete(@PathVariable("idEndereco") Integer idEndereco){
        try{
            fornecedorEnderecoRespoistory.deleteById(idEndereco);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
