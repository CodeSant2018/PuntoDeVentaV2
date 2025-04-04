/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.code.sant.dev.pos.puntodeventav2.modelo;

import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bson.Document;

@Getter
@Setter
@AllArgsConstructor


public class Pedido {
    
    private String proveedor;
    private String idProvedor;
    private List<Document> productos;
    private double subtotal;
    private double descuento;
    private double total;
    private Date fechaEntrega;
    private String nota;
    
    public Document toDocumentPedido(){
        return new Document("Proveedor",proveedor)
                .append("Id_Proveedor", idProvedor)
                .append("Productos", productos)
                .append("SubTotal", subtotal)
                .append("Descuento", descuento)
                .append("Total", total)
                .append("Fecha Entrega", fechaEntrega)
                .append("Nota", nota);
    }
}
