/**
 * FastFood API
 * API básica para melhoria e implementação.
 * 
 * Repositório Produto
 */
package com.kaylane.fastfoodApp.domain.repository;

import com.kaylane.fastfoodApp.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório Produto
 * @author Kaylane
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
