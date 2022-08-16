/**
 * FastFood API
 * API básica para melhoria e implementação.
 * 
 * Repositório Item
 */
package com.kaylane.fastfoodApp.domain.repository;

import com.kaylane.fastfoodApp.domain.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório Item
 * @author com.kaylane
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
    
}
