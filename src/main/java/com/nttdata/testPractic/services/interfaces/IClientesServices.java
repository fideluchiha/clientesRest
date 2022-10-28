/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nttdata.testPractic.services.interfaces;

import com.nttdata.testPractic.models.Response;
import com.nttdata.testPractic.models.clienteResponse;
import com.nttdata.testPractic.models.clientesRequest;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author fidel
 */
@Service
public interface IClientesServices {
    
    Response findXCliente(clientesRequest c);
    
    Response findAll();
}
