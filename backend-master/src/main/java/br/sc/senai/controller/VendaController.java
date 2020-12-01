package br.sc.senai.controller;

import br.sc.senai.model.Fornecedor;
import br.sc.senai.model.MovimentoEstoque;
import br.sc.senai.model.Produto;
import br.sc.senai.model.Venda;
import br.sc.senai.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/sales")
public class VendaController {

    @Autowired
    private VendaRepository vendaRepository;

    @GetMapping("/register")
    public @ResponseBody
    ResponseEntity<Iterable<Venda>> getVendas() {
        try {
            Iterable<Venda> vendas = vendaRepository.findAll();
            if (((Collection<?>) vendas).size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(vendas, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/register/{nrCupomFiscal}")
    public @ResponseBody
    ResponseEntity<Venda> editVenda(@PathVariable("nrCupomFiscal") String nrCupomFiscal,
                                        @RequestBody Venda venda){

        Optional<Venda> vendaData = vendaRepository.finByCupom(nrCupomFiscal);

        try{
            if (vendaData.isPresent()){

                Venda editVenda = vendaData.get();
                editVenda.setNomeCliente(venda.getNomeCliente());
                editVenda.setCpfCnpj(venda.getCpfCnpj());
                editVenda.setNomeVendedor(venda.getNomeVendedor());
                editVenda.setDataVenda(venda.getDataVenda());
                editVenda.setTipoPagamento(venda.getTipoPagamento());

                return new ResponseEntity<>(vendaRepository.save(editVenda), HttpStatus.OK);

            }else{
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }


    @PostMapping(path = "/register")
    public @ResponseBody
    ResponseEntity<Venda> addVenda(@RequestBody Venda venda){

        try{

            Venda novaVenda = new Venda();
            novaVenda.setDataVenda(venda.getDataVenda());
            novaVenda.setNomeCliente(venda.getNomeCliente());
            novaVenda.setCpfCnpj(venda.getCpfCnpj());
            novaVenda.setNomeVendedor(venda.getNomeVendedor());
            novaVenda.setTipoMovimento(venda.getTipoMovimento());
            novaVenda.setNrCupomFiscal(venda.getNrCupomFiscal());
            novaVenda.setTipoPagamento(venda.getTipoPagamento());

            vendaRepository.save(novaVenda);

            return new ResponseEntity<>(novaVenda, HttpStatus.CREATED);

        }catch (Exception e){

            System.out.println(e.getMessage());

            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);

        }

    }

}
