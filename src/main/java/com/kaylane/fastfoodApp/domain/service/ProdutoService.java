/**
 * FastFood API
 * API básica para melhoria e implementação.
 * 
 * Service: ProdutoService
 */
package com.kaylane.fastfoodApp.domain.service;

import com.kaylane.fastfoodApp.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author com.kaylane
 */
@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;
    
    public void excluir(Long produtoId) {
        produtoRepository.deleteById(produtoId);
    }
}
