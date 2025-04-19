/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.code.sant.dev.pos.puntodeventav2.modelo;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;

@Getter
@Setter

public class Inventario {

    private String idProduct;
    private String nombre;
    private String categoria;
    private int stockMin;
    private int stockInicial;
    private double precioCompra;
    private double precioVenta;
    private int porcentajeGanancia;
    private int margen;
    private double ganancia;
    private String descripcion;

    public Inventario(String idProduct, String nombre, String categoria, int stockMin, int stockInicial, double precioCompra, double precioVenta, int porcentajeGanancia, int margen, double ganancia,String descripcion) {
        this.idProduct = idProduct;
        this.nombre = nombre;
        this.categoria = categoria;
        this.stockMin = stockMin;
        this.stockInicial = stockInicial;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.porcentajeGanancia = porcentajeGanancia;
        this.margen = margen;
        this.ganancia = ganancia;
        this.descripcion = descripcion;
    }

    public Document toDocumentInventario() {
        Document doc = new Document("id_Producto", idProduct)
                .append("nombre", this.nombre)
                .append("categoria", this.categoria)
                .append("stockMin", this.stockMin)
                .append("stockInicial", this.stockInicial)
                .append("precioCompra", this.precioCompra)
                .append("precioVenta", this.precioVenta)
                .append("porcentajeGanancia", this.porcentajeGanancia)
                .append("margen", this.margen)
                .append("ganancia", this.ganancia)
                .append("descripcion", this.descripcion);    ;

        return doc;
    }
}
