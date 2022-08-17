/**
 * FastFood API
 * API básica para melhoria e implementação.
 * 
 * Controller ProdutoController
 */
package com.kaylane.fastfoodApp.Api.controller;

import com.kaylane.fastfoodApp.domain.model.Produto;
import com.kaylane.fastfoodApp.domain.repository.ProdutoRepository;
import com.kaylane.fastfoodApp.domain.service.ProdutoService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementa RestController de Produto
 * @author com.kaylane
 */
@RestController
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;
    
    @Autowired
    private ProdutoService produtoService;
    
    //Lista todos os Produtos
    @GetMapping("/produto")
    public List<Produto> showAllProduto() {
        return produtoRepository.findAll();
    }
    
    //Lista os Produtos por Id
    @GetMapping("/produto/{produtoId}")
    public ResponseEntity<Produto> showProduto(@PathVariable Long produtoId) {
        Optional<Produto> produto = produtoRepository.findById(produtoId);
        if (produto.isPresent()) {
            return ResponseEntity.ok(produto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
   
    // Adiciona produto
    @PostMapping("/produto")
    @ResponseStatus(HttpStatus.CREATED)
    public Produto criar(@Valid @RequestBody Produto produto){
        return produtoRepository.save(produto);
    }
    
    // Cancelar produto - ajustar
    @DeleteMapping("/produto/{produtoId}")
    public ResponseEntity<Void> excluir(@PathVariable Long produtoID) {
        //Verifica se produto existe ou não
        
        if(!produtoRepository.existsById(produtoID)) {
            return ResponseEntity.notFound().build();
        }
        
       produtoService.excluir(produtoID);
       return ResponseEntity.noContent().build();
    }
    
//    @PutMapping("/produto/{produtoId}")
//    public Produto atualizar(@Valid @PathVariable Long produtoID,
//                                             @RequestBody Produto produto) {
//        
//        produto.setId(produtoID);
//        produtoRepository.save(produto);
//        return (Produto) ResponseEntity.ok();
//    }
    // TODO Implementar métodos POST PUT DELETE
    
    
}
