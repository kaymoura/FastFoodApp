/**
 * FastFood API
 * API básica para melhoria e implementação.
 * 
 * Controller ClienteController
 */
package com.kaylane.fastfoodApp.Api.controller;

import com.kaylane.fastfoodApp.domain.model.Cliente;
import com.kaylane.fastfoodApp.domain.repository.ClienteRepository;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementa RestController de Cliente
 * @author com.kaylane
 */
@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;
    
    @GetMapping
    public List<Cliente> listar(){
    
        return clienteRepository.findAll();
    }
    
    @GetMapping("/{clienteid}")
    public  ResponseEntity<Cliente> listaId(@PathVariable Long clienteid){
        Optional <Cliente> cliente = clienteRepository.findById(clienteid);
        
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente criar(@Valid @RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }
    
}
