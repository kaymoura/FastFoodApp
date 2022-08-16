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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/itens")
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;
    
    @GetMapping
    public List<Item> listarItem(){
        return itemRepository.findAll();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Item adicionarItem(@RequestBody Item item){
        return itemRepository.save(item);
    }
}
