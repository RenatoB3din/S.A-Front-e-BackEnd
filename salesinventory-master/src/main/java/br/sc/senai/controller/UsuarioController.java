package br.sc.senai.controller;

import br.sc.senai.model.Usuario;
import br.sc.senai.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(path = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //ROTA PARA ADICIONAR NOVOS USUÁRIOS
    @PostMapping(path = "/cadastrar")
    public @ResponseBody
    ResponseEntity<Usuario> adicionarUsuario(@Validated @RequestBody Usuario usuario) {
        try{
            Usuario novoUsuario = usuarioRepository.save(usuario);
            return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    //ROTA PARA ALTERAR O USUARIO
    @PutMapping(path = "/{idUsuario}")
    public @ResponseBody
    ResponseEntity<Usuario> alterarUsuario(@PathVariable("idUsuario") Integer idUsuario,
                                           @RequestBody Usuario usuario) {

        //LOCALIZA O USUARIO PELO ID PARA FAZER A ALTERACAO
        Optional<Usuario> usuarioData = usuarioRepository.findById(idUsuario);

        try{
            if (usuarioData.isPresent()) {
                Usuario alterarUsuario = usuarioData.get();
                alterarUsuario.setNomeCompleto(usuario.getNomeCompleto());
                alterarUsuario.setEmail(usuario.getEmail());
                alterarUsuario.setLogin(usuario.getLogin());
                alterarUsuario.setSenha(usuario.getSenha());
                alterarUsuario.setCpf(usuario.getCpf());
                return new ResponseEntity<>(usuarioRepository.save(alterarUsuario), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(usuario, HttpStatus.EXPECTATION_FAILED);
        }
    }

    //ROTA PARA DELETAR O USUARIO
    @DeleteMapping(path = "/{idUsuario}")
    public @ResponseBody
    ResponseEntity<HttpStatus> deletarUsuario(@PathVariable("idUsuario") Integer idUsuario){
        try{
            usuarioRepository.deleteById(idUsuario);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //ROTAS DE CONSULTAS
    //RETORNAR TODOS OS USUÁRIOS
    @GetMapping(path = "/")
    public @ResponseBody
    ResponseEntity<Iterable<Usuario>> getUsuarios() {
        try {
            Iterable<Usuario> usuarios = usuarioRepository.findAll();
            if(((Collection<?>) usuarios).size() == 0){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //RETORNA USURAIO POR NOME
    @PostMapping(path = "/localizaNomeUsuario/{nomeCompleto}")
    public @ResponseBody
    ResponseEntity<Iterable<Usuario>> findByName(@PathVariable("nomeCompleto") String nomeCompleto,
                                                 @RequestBody Usuario usuario) {
        try{
            Iterable<Usuario> usuarios = usuarioRepository.findAllByName(nomeCompleto);
            if(((Collection<?>) usuarios).size() == 0){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //RETORNA USUARIO POR CPF
    @PostMapping(path = "/localizaCPF/{cpf}")
    public @ResponseBody
    ResponseEntity<Iterable<Usuario>> findByCPF(@PathVariable("cpf") String cpf,
                                                @RequestBody Usuario usuario){
        try{
            Iterable<Usuario> usuarios = usuarioRepository.findByCPF(cpf);
            if(((Collection<?>) usuarios).size() == 0){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
