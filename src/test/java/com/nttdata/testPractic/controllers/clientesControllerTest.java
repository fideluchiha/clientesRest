/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nttdata.testPractic.controllers;

import com.nttdata.testPractic.models.Response;
import com.nttdata.testPractic.models.clientesRequest;
import static junit.framework.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

/**
 *
 * @author fidel
 */

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = clientesController.class)
public class clientesControllerTest {
    
    
    @InjectMocks clientesController controller;
    
    @Test
    public void findAllTest() {
        
        Response response = controller.findAll();
        assertEquals(HttpStatus.OK.value(), response.getCode());
    }
    
    @Test
    public void findXClienteTest() {
       
        Response response = controller.findXCliente
        (clientesRequest.builder()
                .documento(23445322)
                .tipoDocumento("C").build());
        
        assertEquals(HttpStatus.OK.value(), response.getCode());
    }
    
}
