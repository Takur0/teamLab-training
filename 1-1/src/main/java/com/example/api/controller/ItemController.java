package com.example.api.controller;

import java.util.Optional;
import java.util.List;

import com.example.api.data.Item;
import com.example.api.service.ItemService;
import com.example.api.exception.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping
    List<Item> getItems() {
        List<Item> items = itemService.findAll();
        if(!items.isEmpty()) {
            return itemService.findAll();
        } else {
            throw new NotFoundException("No items.");
        }
    }

    @GetMapping(path = "{id}")
    Optional<Item> getItem(@PathVariable Integer id) {
        Optional<Item> item  = itemService.findItem(id);  
        item.orElseGet(() -> {
            throw new NotFoundException("This ID is not found.");
        });
        return item;            
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    List<Item> postItems(@RequestBody List<Item> items) {
        for (Item item : items) {
            Optional<Item> temp_item  = itemService.findItem(item.getId());
            if(temp_item.isPresent()){
                throw new ConflictException("Conflict.");
            }
        }
        return itemService.create(items);
    }

    @PutMapping(path = "{id}")
    Item putItem(@PathVariable Integer id, @RequestBody Item item) {
        item.setId(id);
        return itemService.update(item);
    }

    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteItem(@PathVariable Integer id) {
        Optional<Item> item  = itemService.findItem(id);  
        item.orElseGet(() -> {
            throw new NotFoundException("This ID is not found.");
        });
        itemService.delete(id);
    }
}