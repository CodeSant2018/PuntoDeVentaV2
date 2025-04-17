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

public class Proveedor {
    
    private String nombre;
    private String id;
    private String contanto;
    private String dirreccion;
    private String productosSum;
    private String terminosPago;
    private String notas;

    public Proveedor(String nombre, String id, String contanto, String dirreccion, String productosSum, String terminosPago, String notas) {
        this.nombre = nombre;
        this.id = id;
        this.contanto = contanto;
        this.dirreccion = dirreccion;
        this.productosSum = productosSum;
        this.terminosPago = terminosPago;
        this.notas = notas;
    }
    
    public Document toDocumentProveedor(){
        return new Document("Nombre Proveedor",nombre)
                .append("Id_Proveedor", id)
                .append("Contacto", contanto)
                .append("Dirección", dirreccion)
                .append("Productos Suministrados", productosSum)
                .append("Terminos de Pago", terminosPago)
                .append("Notas", notas);
    }
    
}
