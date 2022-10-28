/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nttdata.testPractic.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Required;

/**
 *
 * @author fidel
 */
@Data
@ToString
@Builder
public class clientesRequest {
    
    @JsonProperty("tipoDocumento")
    @NonNull
    private String tipoDocumento;
    
    @JsonProperty("documento")
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private int documento;
}
