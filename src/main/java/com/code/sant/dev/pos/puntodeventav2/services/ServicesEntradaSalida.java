/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.code.sant.dev.pos.puntodeventav2.services;

import com.code.sant.dev.pos.puntodeventav2.entity.GestionData;
import com.code.sant.dev.pos.puntodeventav2.modelo.EntradaSalida;
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
 */
public class ServicesEntradaSalida implements RepositoryVentas<EntradaSalida>{

   /* private ReformaData data = ReformaData.getInstance();
    private MongoDatabase db = data.getData();
    private MongoCollection<Document> entradaSalida = db.getCollection("Entrada/Salida");*/
    
    private GestionData entradaSalida = new GestionData("Entrada/Salida");

    @Override
    public void crear(EntradaSalida t) {
        try {
            entradaSalida.getCollectionData().insertOne(t.documentEntradaSalida());
            JOptionPane.showMessageDialog(null, "Efectivo Ingresado","Correcto",JOptionPane.INFORMATION_MESSAGE);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public MongoCollection<Document> findAll() {
        return entradaSalida.getCollectionData();
    }

    @Override
    public void delete(Date t) {
         try {
            entradaSalida.getCollectionData().deleteOne(Filters.eq("Fecha",t));
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String t, EntradaSalida a) {
        try {
            entradaSalida.getCollectionData().updateOne(Filters.eq("Fecha",t), new Document("$set",a.documentEntradaSalida()));
            JOptionPane.showMessageDialog(null, "Dato actualizado","Correcto",JOptionPane.INFORMATION_MESSAGE);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Document findByDate(String t) {
       return entradaSalida.getCollectionData().find(Filters.eq("Fecha",t)).first();
    }
    
    
}
