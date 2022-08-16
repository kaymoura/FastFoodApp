/**
 * FastFood API
 * API básica para melhoria e implementação.
 * 
 * Repositório Cliente
 */
package com.kaylane.fastfoodApp.domain.repository;

import com.kaylane.fastfoodApp.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório Cliente
 * @author com.kaylane
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
}
