package br.sc.senai.controller;

import br.sc.senai.model.Perfil;
import br.sc.senai.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(path = "/perfil")
public class PerfilController {

    @Autowired
    private PerfilRepository perfilRepository;

    //CADASTRAR NOVO PERFIL
    @PostMapping(path = "/cadastrar")
    public @ResponseBody
    ResponseEntity<Perfil> cadastrarPerfil(@RequestBody Perfil perfil){
        try{
            Perfil novoPerfil = perfilRepository.save(perfil);
            return new ResponseEntity<>(novoPerfil, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    //ALTERAR PERFIL CADASTRADO
    @PutMapping(path = "/{idPerfil}")
    public @ResponseBody
    ResponseEntity<Perfil> alterarPerfil(@PathVariable("idPerfil") Integer idPerfil,
                                         @RequestBody Perfil perfil){
        //LOCALIZAR O IDPERFIL INFORMADO
        Optional<Perfil> perfilData = perfilRepository.findById(idPerfil);

        try{
            if(perfilData.isPresent()){
                Perfil alterarPerfil = perfilData.get();
                alterarPerfil.setDescricao(perfil.getDescricao());
                return new ResponseEntity<Perfil>(perfilRepository.save(alterarPerfil), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping(path = "/{idPerfil}")
    public @ResponseBody
    ResponseEntity<Perfil> deletarPerfil(@PathVariable("idPerfil") Integer idPerfil){
        try{
            perfilRepository.deleteById(idPerfil);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    //LOCALIZAR TODOS OS PERFIS
    @GetMapping(path = "/")
    public @ResponseBody
    ResponseEntity<Iterable<Perfil>> getAllPerfis(){
        try{
            Iterable<Perfil> perfis = perfilRepository.findAll();
            if(((Collection<?>) perfis).size() == 0){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(perfis, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
