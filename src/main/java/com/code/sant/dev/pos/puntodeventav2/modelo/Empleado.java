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

public class Empleado extends Persona {

    private String idEmpleado;
    private Date fechaInicio;
    private String puesto;
    private String estado;
    private String contraseña;

    public Empleado(String nombre, String telefono, String correo, Date fecha, String idEmpleado,
            Date fechaN, String puesto, String estado, String contraseña) {
        super(nombre, telefono, correo, fecha);
        this.idEmpleado = idEmpleado;
        this.fechaInicio = fechaN;
        this.puesto = puesto;
        this.estado = estado;
        this.contraseña = contraseña;
    }

    public Document toDocumentEmpleado() {
        return new Document("Nombre", getNombre())
                .append("Id_Empleado", idEmpleado)
                .append("Telefono", getTelefono())
                .append("Correo", getCorreo())
                .append("Fecha Nacimiento", getFecha())
                .append("Fecha Inicio", fechaInicio)
                .append("Puesto", puesto)
                .append("Estado", estado)
                .append("Contraseña", contraseña);
    }

}
