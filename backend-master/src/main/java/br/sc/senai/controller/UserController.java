package br.sc.senai.controller;

import br.sc.senai.model.User;
import br.sc.senai.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/users")
    public @ResponseBody
    ResponseEntity<User> addNewUser(@RequestBody User user){
        try{
            User newUser = userRepository.save(user);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

//    //ROTA PARA ALTERAR O USUARIO
//    @PutMapping(path = "/{idUsuario}")
//    public @ResponseBody
//    ResponseEntity<Usuario> alterarUsuario(@PathVariable("idUsuario") Integer idUsuario,
//                                           @RequestBody Usuario usuario) {
//
//        //LOCALIZA O USUARIO PELO ID PARA FAZER A ALTERACAO
//        Optional<Usuario> usuarioData = userRepository.findById(idUsuario);
//
//        try{
//            if (usuarioData.isPresent()) {
//                Usuario alterarUsuario = usuarioData.get();
//                alterarUsuario.setName(usuario.getName());
//                alterarUsuario.setEmail(usuario.getEmail());
//                alterarUsuario.setLogin(usuario.getLogin());
//                alterarUsuario.setSenha(usuario.getSenha());
//                alterarUsuario.setCpf(usuario.getCpf());
//                return new ResponseEntity<>(userRepository.save(alterarUsuario), HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            }
//        }catch (Exception e){
//            return new ResponseEntity<>(usuario, HttpStatus.EXPECTATION_FAILED);
//        }
//    }
//
//    //ROTA PARA DELETAR O USUARIO
//    @DeleteMapping(path = "/{idUsuario}")
//    public @ResponseBody
//    ResponseEntity<HttpStatus> deletarUsuario(@PathVariable("idUsuario") Integer idUsuario){
//        try{
//            userRepository.deleteById(idUsuario);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }catch (Exception e){
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    //ROTAS DE CONSULTAS
//    //RETORNAR TODOS OS USUÁRIOS
//    @GetMapping(path = "/")
//    public @ResponseBody
//    ResponseEntity<Iterable<Usuario>> getUsuarios() {
//        try {
//            Iterable<Usuario> usuarios = userRepository.findAll();
//            if(((Collection<?>) usuarios).size() == 0){
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(usuarios, HttpStatus.OK);
//        }catch (Exception e){
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    //RETORNA USURAIO POR NOME
//    @PostMapping(path = "/localizaNomeUsuario/{nomeCompleto}")
//    public @ResponseBody
//    ResponseEntity<Iterable<Usuario>> findByName(@PathVariable("nomeCompleto") String nomeCompleto,
//                                                 @RequestBody Usuario usuario) {
//        try{
//            Iterable<Usuario> usuarios = userRepository.findAllByName(nomeCompleto);
//            if(((Collection<?>) usuarios).size() == 0){
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(usuarios, HttpStatus.OK);
//        }catch (Exception e){
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    //RETORNA USUARIO POR CPF
//    @PostMapping(path = "/localizaCPF/{cpf}")
//    public @ResponseBody
//    ResponseEntity<Iterable<Usuario>> findByCPF(@PathVariable("cpf") String cpf,
//                                                @RequestBody Usuario usuario){
//        try{
//            Iterable<Usuario> usuarios = userRepository.findByCPF(cpf);
//            if(((Collection<?>) usuarios).size() == 0){
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(usuarios, HttpStatus.OK);
//        }catch (Exception e){
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
