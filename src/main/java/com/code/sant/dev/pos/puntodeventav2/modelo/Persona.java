/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.code.sant.dev.pos.puntodeventav2.modelo;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Persona {
    
    private String nombre;
    private String telefono;
    private String correo;
    private Date fecha;

    public Persona(String nombre, String telefono, String correo, Date fecha) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.fecha = fecha;
    }
    
    
}
