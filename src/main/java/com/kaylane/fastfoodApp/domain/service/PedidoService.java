/**
 * FastFood API
 * API básica para melhoria e implementação.
 * 
 * Service: PedidoService
 */
package com.kaylane.fastfoodApp.domain.service;

import com.kaylane.fastfoodApp.domain.model.Pedido;
import com.kaylane.fastfoodApp.domain.model.StatusPedido;
import com.kaylane.fastfoodApp.domain.repository.PedidoRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author com.kaylane
 */
@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;
    
    public Pedido salvar(Pedido pedido) {
        // Atualiza campos abertoEm e status
        pedido.setAbertoEm(LocalDateTime.now());
        pedido.setStatus(StatusPedido.CONFIRMADO);
        
        return pedidoRepository.save(pedido);
    }
    
    public Pedido preparo(Pedido pedido) {
        // Atualiza campos status para preparando
        pedido.setStatus(StatusPedido.PREPARANDO);
        
        return pedidoRepository.save(pedido);
    }
    
    public Pedido pronto(Pedido pedido) {
        // Atualiza campos fechadoEm e status para pronto
        pedido.setFechadoEm(LocalDateTime.now());
        pedido.setStatus(StatusPedido.PRONTO);
        
        return pedidoRepository.save(pedido);
    }
}
