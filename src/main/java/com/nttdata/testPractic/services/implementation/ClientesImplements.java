/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nttdata.testPractic.services.implementation;

import com.nttdata.testPractic.controllers.clientesController;
import com.nttdata.testPractic.models.Response;
import com.nttdata.testPractic.models.clienteResponse;
import com.nttdata.testPractic.models.clientesRequest;
import com.nttdata.testPractic.services.interfaces.IClientesServices;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author fidel
 */
@Component
public class ClientesImplements implements IClientesServices{
   
    @Autowired clientesController clientesController;
    @Override
    public Response findAll() {
        
      return  clientesController.findAll(); 
      
    }

    @Override
    public Response findXCliente(clientesRequest c) {
        
            return clientesController.findXCliente(c);
            
    }
        
    
}
