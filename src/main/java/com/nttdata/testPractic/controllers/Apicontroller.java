/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nttdata.testPractic.controllers;

import com.nttdata.testPractic.models.Response;
import com.nttdata.testPractic.models.clientesRequest;
import com.nttdata.testPractic.services.interfaces.IClientesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fidel
 */

    @RestController
    @CrossOrigin("*")
    @RequestMapping("/clientes")
    
public class Apicontroller {
        
            @Autowired
    private IClientesServices IClientesServices;
    
        @GetMapping(value ="/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response index() {
        
        return  IClientesServices.findAll();
    
    }
    
    @PostMapping(value ="/findXcliente", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response saveLocation(@RequestBody clientesRequest request){
        
        return IClientesServices.findXCliente(request);
    }
}
