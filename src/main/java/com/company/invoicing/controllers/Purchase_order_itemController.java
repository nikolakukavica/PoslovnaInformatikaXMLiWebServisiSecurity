package com.company.invoicing.controllers;

import com.company.invoicing.intercepters.AuthorityAnnotation;
import com.company.invoicing.models.Purchase_order_item;
import com.company.invoicing.security.JwtTokenUtil;
import com.company.invoicing.security.JwtUser;
import com.company.invoicing.security.JwtUserDetailsServiceImpl;
import com.company.invoicing.services.Purchase_order_itemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping(value ="/purchase_order_item")
public class Purchase_order_itemController {

    @Autowired
    private Purchase_order_itemService service;

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtUserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @AuthorityAnnotation(method = "getAll",table = "purchase_order_item")
    @RequestMapping(method = RequestMethod.GET)
    public List<Purchase_order_item> getAll(HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        if(user.getRole().getName().equals("superuser"))
            return service.findAll();
        else
            return service.findAllForUser(user.getCompany().getCompany_id());
    }

    @AuthorityAnnotation(method = "getOne",table = "purchase_order_item")
    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public Purchase_order_item find(@PathVariable long id){
        return service.findOne(id);
    }

    @AuthorityAnnotation(method = "create",table = "purchase_order_item")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(@RequestBody Purchase_order_item purchase_order_item,HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        //service.create(purchase_order_item);
        service.create(purchase_order_item,username);
    }

    @AuthorityAnnotation(method = "update",table = "purchase_order_item")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void update(@RequestBody Purchase_order_item purchase_order_item,HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        //service.update(purchase_order_item);
        service.update(purchase_order_item,username);
    }

    @AuthorityAnnotation(method = "delete",table = "purchase_order_item")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void remove(@PathVariable long id,HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        //service.remove(id);
        service.remove(id,username);
    }

    @AuthorityAnnotation(method = "search",table = "purchase_order_item")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public List<Purchase_order_item> search(@RequestBody Purchase_order_item purchase_order_item) {
        return service.search(purchase_order_item);
    }
}