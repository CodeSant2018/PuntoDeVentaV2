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


public class AgregarPedido {
    private String nombre;
    private String categoria;
    private String contacto;
    private String productosSuministros;
    private String terminoPago;
    private String notas;

    public AgregarPedido(String nombre, String categoria, String contacto, String productosSuministros, String terminoPago, String notas) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.contacto = contacto;
        this.productosSuministros = productosSuministros;
        this.terminoPago = terminoPago;
        this.notas = notas;
    }
    
    
    

public Document toDocumentAgregarPedido() {
    return new Document()
        .append("nombre", nombre)
        .append("categoria",categoria)
        .append("contacto", contacto)
        .append("productosSuministros", productosSuministros)
        .append("terminoPago", terminoPago)
        .append("notas", notas);
}

    
}
