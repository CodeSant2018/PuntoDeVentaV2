/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.code.sant.dev.pos.puntodeventav2.services;

import com.code.sant.dev.pos.puntodeventav2.entity.GestionData;
import com.code.sant.dev.pos.puntodeventav2.modelo.Categoria;
import com.code.sant.dev.pos.puntodeventav2.repository.RepositoryClientes;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

/**
 *
 * @author thevoid
 */
public class ServicesCategoria implements RepositoryClientes<Categoria> {

    private GestionData categoria = new GestionData("Categorías");

    @Override
    public void crear(Categoria t) {
        categoria.getCollectionData().insertOne(t.toDocumentCategoria());
    }

    @Override
    public MongoCollection<Document> findAll() {
        return categoria.getCollectionData();
    }

    @Override
    public void delete(String t) {
        categoria.getCollectionData().deleteOne(Filters.eq("Categoría", t));
    }

    @Override
    public void update(String t, Categoria a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Document findByName(String t) {
        return categoria.getCollectionData().find(Filters.eq("Categoría",t)).first();
    }

}
