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
public class CierreDeCaja {
    
    private Date fecha;
    private String turno;
    private String empleado;
    private Caja cajaDatos;
    private List<Document> entradasSalidas;
    private double totalEntradas;
    private double totalSalidas;
    private double ganancias;

    public CierreDeCaja(Date fecha, String turno, String empleado, Caja cajaDatos, List<Document> entradasSalidas, double ganancias) {
        this.fecha = fecha;
        this.turno = turno;
        this.empleado = empleado;
        this.cajaDatos = cajaDatos;
        this.entradasSalidas = entradasSalidas;
        this.ganancias = ganancias;
    }
    
    public Document toDocumentCierreCaja(){
        return new Document("Fecha",fecha)
                .append("Turno", turno)
                .append("Empleado", empleado)
                .append("Caja", cajaDatos.toDocumentCaja())
                .append("Entrada/Salida", entradasSalidas)
                .append("Ganancias", ganancias);
    }
    
    
}
