/**
 * FastFood API
 * API básica para melhoria e implementação.
 * 
 * Controller ItemController
 */
package com.kaylane.fastfoodApp.Api.controller;

import com.kaylane.fastfoodApp.domain.model.Item;
import com.kaylane.fastfoodApp.domain.repository.ItemRepository;
import java.util.List;
import java.util.Optional;
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
 * Implementa RestController de Item
 * @author com.kaylane
 */
@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;
    
    // Lista todos os items
    @GetMapping
    public List<Item> listarItem(){
        return itemRepository.findAll();
    }
    
    // Lista os items pelo id
    @GetMapping("/{itemsid}")
    public ResponseEntity<Item> listaId(@PathVariable Long itemid){
        Optional <Item> item = itemRepository.findById(itemid);
        
        if(item.isPresent()) {
            return ResponseEntity.ok(item.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    // Adiciona items
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Item adicionarItem(@RequestBody Item item){
        return itemRepository.save(item);
    }
}
