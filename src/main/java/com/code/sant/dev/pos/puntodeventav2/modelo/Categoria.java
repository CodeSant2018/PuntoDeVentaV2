/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.code.sant.dev.pos.puntodeventav2.modelo;

import org.bson.Document;

/**
 *
 * @author thevoid
 */
public class Categoria {
    
    private String categoria;

    public Categoria(String categoria) {
        this.categoria=categoria;
    }
    
    
    
    public Document toDocumentCategoria(){
        return new Document("Categoría",categoria);
    }
}
