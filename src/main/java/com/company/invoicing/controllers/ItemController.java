package com.company.invoicing.controllers;

import com.company.invoicing.intercepters.AuthorityAnnotation;
import com.company.invoicing.models.Item;
import com.company.invoicing.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(value ="/item")
public class ItemController {

    @Autowired
    private ItemService service;

    @AuthorityAnnotation(method = "getAll",table = "item")
    @RequestMapping(method = RequestMethod.GET)
    public List<Item> getAll(){
        return service.findAll();
    }

    @AuthorityAnnotation(method = "getOne",table = "item")
    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public Item find(@PathVariable long id){
        return service.findOne(id);
    }

    @AuthorityAnnotation(method = "create",table = "item")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(@RequestBody Item item){
        service.create(item);
    }

    @AuthorityAnnotation(method = "update",table = "item")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void update(@RequestBody Item item) {
    service.update(item);
    }

    @AuthorityAnnotation(method = "delete",table = "item")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void remove(@PathVariable long id) {
        service.remove(id);
    }

    @AuthorityAnnotation(method = "search",table = "item")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public List<Item> search(@RequestBody Item item) {
        return service.search(item);
    }

    @AuthorityAnnotation(method = "findAllValid",table = "item")
    @RequestMapping(value="/findAllValid", method = RequestMethod.GET)
    public List<Item> findAllValid(){
        return service.findAllValid();
    }
}