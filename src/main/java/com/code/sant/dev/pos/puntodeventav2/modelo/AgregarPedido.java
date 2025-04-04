/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.code.sant.dev.pos.puntodeventav2.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bson.Document;

@Getter
@Setter
@AllArgsConstructor

public class AgregarPedido {
    private String nombre;
    private String categoria;
    private String contacto;
    private String productosSuministros;
    private String terminoPago;
    private String notas;
    
    

public Document toDocumentAgregarPedido() {
    return new Document()
        .append("nombre", getNombre())
        .append("categoria", getCategoria())
        .append("contacto", getContacto())
        .append("productosSuministros", getProductosSuministros())
        .append("terminoPago", getTerminoPago())
        .append("notas", getNotas());
}

    
}
