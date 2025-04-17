/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.code.sant.dev.pos.puntodeventav2.modelo;

import java.util.Date;
import java.util.List;
import java.util.Random;
import lombok.Getter;
import lombok.Setter;
import org.bson.Document;

@Setter
@Getter
public class CierreDeCaja {

    private String idCaja;
    private Caja cajaDatos;
    private List<Document> entradasSalidas;
    private double totalEntradas;
    private double totalSalidas;
    private double ganancias;

    public CierreDeCaja(Caja cajaDatos, List<Document> entradasSalidas, double ganancias) {
        this.idCaja=idGenerator();
        this.cajaDatos = cajaDatos;
        this.entradasSalidas = entradasSalidas;
        this.ganancias = ganancias;
    }

    public Document toDocumentCierreCaja() {
        return new Document("Id_Cierre", idCaja)
                .append("Caja", cajaDatos.toDocumentCaja())
                .append("Entrada/Salida", entradasSalidas)
                .append("Ganancias", ganancias);
    }

    private String idGenerator(){
        Random rd = new Random();
        int num = rd.nextInt(1000000000);
        return String.valueOf(num);
    }
}
