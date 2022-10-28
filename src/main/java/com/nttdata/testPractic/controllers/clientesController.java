/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nttdata.testPractic.controllers;

import com.nttdata.testPractic.models.Response;
import com.nttdata.testPractic.models.clienteResponse;
import com.nttdata.testPractic.models.clientesRequest;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 *
 * @author fidel
 */

@Component
@Log4j2
public class clientesController {

    private List<clienteResponse> listClientes = new ArrayList();
    public clientesController() {
        
        listClientes.add(clienteResponse.builder().
                tipoDocumento("C").
                documento(112625234).
                primerNombre("fidel")
                .segundoNombre("v")
                .primerApellido("morneo")
                .segundoApellido("tovar")
                .direccion("calle 15")
                .cuidadReferencia("soacha")
                .telefono(465464).build()
        );
        listClientes.add(clienteResponse.builder().
                tipoDocumento("C").
                documento(23445322).
                primerNombre("pedro")
                .segundoNombre("juan")
                .primerApellido("perez")
                .segundoApellido("smit")
                .direccion("calle 12")
                .cuidadReferencia("bogota")
                .telefono(1231).build()
        );
    }
    
   
    
    
    public Response findXCliente(clientesRequest c){
        try
        {
        log.info("Datos de entrada---"+c.toString());
        log.info("Listado completo de usuarios---"+listClientes.toString());
        
            if (!c.getTipoDocumento().equalsIgnoreCase("C") &&
                    !c.getTipoDocumento().equalsIgnoreCase("P") ) {
                
                 return  Response.builder().
                        code(HttpStatus.BAD_REQUEST.value()).status(Boolean.FALSE)
                    .message("Tipo de documento no permitido").build();
                
            }
        var a = listClientes.stream()
                .filter(list -> c.getTipoDocumento().equals(list.getTipoDocumento()))
                .filter(list ->  c.getDocumento() == list.getDocumento())
                .findFirst();
        
            if (a.isPresent()) {
                log.info("Usuario existe");
                return  Response.builder().data(a).
                        code(HttpStatus.OK.value()).status(Boolean.TRUE)
                    .message("Usuario existe!!!").build();
            }else {
                log.info("Usuario No existe");
                return  Response.builder().
                        code(HttpStatus.NO_CONTENT.value()).status(Boolean.FALSE)
                    .message("Usuario no existe!!!").build();
            }
        
        
        } catch (RuntimeException e) {
            log.warn("Error interno", e);
            return Response.builder().code(HttpStatus.INTERNAL_SERVER_ERROR.value()).status(Boolean.FALSE)
                    .message("Error interno").build();
        }
    
    }
    
   public Response findAll(){
       try
        {
        return  Response.builder().data(listClientes).
                        code(HttpStatus.OK.value()).status(Boolean.TRUE)
                    .message("Lista completa!!!").build();
        } catch (RuntimeException e) {
            log.warn("Error interno", e);
            return Response.builder().code(HttpStatus.INTERNAL_SERVER_ERROR.value()).status(Boolean.FALSE)
                    .message("Error interno").build();
        }
    }
    
}
