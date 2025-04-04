/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.code.sant.dev.pos.puntodeventav2.modelo;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import org.bson.Document;

@Setter
@Getter
public class EntradaSalida {
    
    private Date fecha;
    private double monto;
    private String tipo;
    private String motivo;
    private String nota;

    public EntradaSalida(Date fecha, double monto, String tipo, String motivo, String nota) {
        this.fecha = fecha;
        this.monto = monto;
        this.tipo = tipo;
        this.motivo = motivo;
        this.nota = nota;
    }
    
    public Document documentEntradaSalida(){
        return new Document("Fecha",fecha)
                .append("Monto", monto)
                .append("Tipo", tipo)
                .append("Motivo", motivo)
                .append("Nota", nota);
    }
    
}
