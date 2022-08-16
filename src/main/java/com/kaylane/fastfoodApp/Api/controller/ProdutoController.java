/**
 * FastFood API
 * API básica para melhoria e implementação.
 * 
 * Controller ProdutoController
 */
package com.kaylane.fastfoodApp.Api.controller;

import com.kaylane.fastfoodApp.domain.model.Produto;
import com.kaylane.fastfoodApp.domain.repository.ProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementa RestController de Produto
 * @author KGe
 */
@RestController
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;
    
    @GetMapping("/produto")
    public List<Produto> showAllProduto() {
        return produtoRepository.findAll();
    }
    
    // TODO Implementar metodo showById
    // TODO Implementar métodos POST PUT DELETE
    
    
}
