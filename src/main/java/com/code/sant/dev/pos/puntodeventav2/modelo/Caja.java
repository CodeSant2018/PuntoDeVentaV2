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
public class Caja {

    private Date fecha;
    private String turno;
    private String empleado;

    private double ventaEfectivo;
    private double ventaTransferencia;
    private double ventaTarjeta;
    private double montoInicial;
    private double efectivoEsperado;
    private double totalEfectivo;
    private double diferencia;

    public Caja(Date fecha, String turno, String empleado, double ventaEfectivo, double ventaTransferencia, double ventaTarjeta, double montoInicial, double efectivoEsperado, double totalEfectivo, double diferencia) {
        this.fecha = fecha;
        this.turno = turno;
        this.empleado = empleado;
        this.ventaEfectivo = ventaEfectivo;
        this.ventaTransferencia = ventaTransferencia;
        this.ventaTarjeta = ventaTarjeta;
        this.montoInicial = montoInicial;
        this.efectivoEsperado = efectivoEsperado;
        this.totalEfectivo = totalEfectivo;
        this.diferencia = diferencia;
    }

    public Document toDocumentCaja() {
        Document doc = new Document("fecha", this.fecha);

        doc.append("turno", this.turno)
                .append("empleado", this.empleado)
                .append("ventaEfectivo", this.ventaEfectivo)
                .append("ventaTransferencia", this.ventaTransferencia)
                .append("ventaTarjeta", this.ventaTarjeta)
                .append("montoInicial", this.montoInicial)
                .append("efectivoEsperado", this.efectivoEsperado)
                .append("totalEfectivo", this.totalEfectivo)
                .append("diferencia", this.diferencia);

        return doc;
    }
}
