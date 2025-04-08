/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.code.sant.dev.pos.puntodeventav2.services;

import com.code.sant.dev.pos.puntodeventav2.entity.GestionData;
import com.code.sant.dev.pos.puntodeventav2.modelo.Caja;
import com.code.sant.dev.pos.puntodeventav2.repository.RepositoryVentas;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import java.util.Date;
import org.bson.Document;

/**
 *
 * @author codesant
 */
public class ServicesCaja implements RepositoryVentas<Caja>{
    
    private GestionData caja = new GestionData("Caja");

    @Override
    public void crear(Caja t) {
        try {
            caja.getCollectionData().insertOne(t.toDocumentCaja());
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public MongoCollection<Document> findAll() {
        return caja.getCollectionData();
    }

    @Override
    public void delete(Date t) {
        try {
             caja.getCollectionData().deleteOne(Filters.eq("fecha",t));
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String t, Caja a) {
        try {
             caja.getCollectionData().updateOne(Filters.eq("fecha",t), new Document("$set",a.toDocumentCaja()));
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Document findByDate(String t) {
       return  caja.getCollectionData().find(Filters.eq("fecha",t)).first();
    }
}
