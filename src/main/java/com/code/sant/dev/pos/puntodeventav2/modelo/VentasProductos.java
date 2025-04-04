/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.code.sant.dev.pos.puntodeventav2.modelo;

import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.bson.Document;


@Setter
@Getter

public class VentasProductos {
    private Date fecha;
    private int cantProductos;
    private double totalVenta;
    private double ganancias;
    private List<Document> productos;
    private String tipoPago;
    
    public Document toDocumentVentasProductos() {
    Document doc = new Document();
    
    doc.append("fecha", this.fecha)
       .append("cantProductos", this.cantProductos)
       .append("totalVenta", this.totalVenta)
       .append("ganancias", this.ganancias)
       .append("productos", this.productos)  // List<Document> se puede guardar directamente
       .append("tipoPago", this.tipoPago);
    
    return doc;
}
    
    
}
