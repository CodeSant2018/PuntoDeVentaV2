/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.code.sant.dev.pos.puntodeventav2.modelo;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import org.bson.Document;

@Getter
@Setter

public class Cliente extends Persona {

    private String tipoCliente;
    private String direccion;
    private String nota;

    public Cliente(String nombre, String telefono, String correo, Date fecha, String tipoCliente, String direccion, String nota) {
        super(nombre, telefono, correo, fecha);
        this.tipoCliente = tipoCliente;
        this.direccion = direccion;
        this.nota = nota;
    }

    public Document toDocumentCliente() {
        return new Document("Nombre", getNombre())
                .append("Telefono", getTelefono())
                .append("Correo", getCorreo())
                .append("FechaNacimiento", getFecha())
                .append("TipoCliente", tipoCliente)
                .append("Direccion", direccion)
                .append("Nota", nota);
    }
}
