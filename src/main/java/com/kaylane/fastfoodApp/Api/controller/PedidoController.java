/**
 * FastFood API
 * API básica para melhoria e implementação.
 * 
 * Controller PedidoController
 */
package com.kaylane.fastfoodApp.Api.controller;

import com.kaylane.fastfoodApp.domain.model.Pedido;
import com.kaylane.fastfoodApp.domain.repository.PedidoRepository;
import com.kaylane.fastfoodApp.domain.service.PedidoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementa RestController de Pedido
 * @author com.kaylane
 */
@RestController
public class PedidoController {
    
    @Autowired
    private PedidoRepository pedidoRepository;
    
    @Autowired
    private PedidoService pedidoService;
                
    @GetMapping("/pedido")
    public List<Pedido> showAllPedido() {
        return pedidoRepository.findAll();
    }
    
    @GetMapping("/pedido/{pedidoId}")
    public ResponseEntity<Pedido> showPedido(@PathVariable Long pedidoId) {
        Optional<Pedido> pedido = pedidoRepository.findById(pedidoId);
        if (pedido.isPresent()) {
            return ResponseEntity.ok(pedido.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/pedido")
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido addPedido(@RequestBody Pedido pedido) {
        
        pedidoService.salvar(pedido);
        
        return pedido;
    }
    
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido preparaPedido(@RequestBody Pedido pedido) {
        
        pedidoService.preparo(pedido);
        
        return pedido;
    }
    
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido prontoPedido(@RequestBody Pedido pedido) {
        
        pedidoService.pronto(pedido);
        
        return pedido;
    }
    //Teste
//    @PostMapping("/pedido")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Pedido cancelPedido(@RequestBody Pedido pedido) {
//        pedidoRepository.
//        pedidoService.salvar(pedido);
//        
//        return pedido;
//    }

    // TODO Cancelar pedido
    // TODO Listar pedidos com status específico
    
}