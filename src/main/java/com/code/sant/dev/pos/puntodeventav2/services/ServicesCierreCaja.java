/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.code.sant.dev.pos.puntodeventav2.services;

import com.code.sant.dev.pos.puntodeventav2.entity.GestionData;
import com.code.sant.dev.pos.puntodeventav2.modelo.CierreDeCaja;
import com.code.sant.dev.pos.puntodeventav2.repository.RepositoryVentas;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import java.util.Date;
import javax.swing.JOptionPane;
import org.bson.Document;

/**
 *
 * @author codesant
 * 
 */
public class ServicesCierreCaja implements RepositoryVentas<CierreDeCaja>{
    
    /*private ReformaData reforma = ReformaData.getInstance();
    private MongoDatabase data = reforma.getData();
    private MongoCollection<Document> cierreCaja = data.getCollection("Cierre_Caja");*/
    
    private GestionData cierreCaja = new GestionData("Cierre_Caja");

    @Override
    public void crear(CierreDeCaja t) {
        try {
            cierreCaja.getCollectionData().insertOne(t.toDocumentCierreCaja());
            JOptionPane.showMessageDialog(null, "Cierre de turno Generado","Correcto",JOptionPane.INFORMATION_MESSAGE);
        } catch (MongoException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public MongoCollection<Document> findAll() {
        return cierreCaja.getCollectionData();
    }

    @Override
    public void delete(Date t) {
        try {
            cierreCaja.getCollectionData().deleteOne(Filters.eq("fecha",t));
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String t, CierreDeCaja a) {
         try {
            cierreCaja.getCollectionData().updateOne(Filters.eq("fecha",t),new Document("$set",a.toDocumentCierreCaja()));
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Document findByDate(String t) {
        return cierreCaja.getCollectionData().find(Filters.eq("fecha")).first();
    }
    
}
