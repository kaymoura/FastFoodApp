/**
 * FastFood API
 * API básica para melhoria e implementação.
 * 
 * Repositório Pedido
 */
package com.kaylane.fastfoodApp.domain.repository;

import com.kaylane.fastfoodApp.domain.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório Pedido
 * @author com.kaylane
 */
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    
}
