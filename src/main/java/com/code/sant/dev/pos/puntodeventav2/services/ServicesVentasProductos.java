/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.code.sant.dev.pos.puntodeventav2.services;

import com.code.sant.dev.pos.puntodeventav2.entity.GestionData;
import com.code.sant.dev.pos.puntodeventav2.modelo.VentasProductos;
import com.code.sant.dev.pos.puntodeventav2.repository.Repositorytransactions;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import javax.swing.JOptionPane;
import org.bson.Document;

/**
 *
 * @author thevoid
 */
public class ServicesVentasProductos implements Repositorytransactions<VentasProductos> {

    private GestionData ventasProdcuts = new GestionData("Ventas_Productos");

    @Override
    public void crear(VentasProductos t) {
        try {
            ventasProdcuts.getCollectionData().insertOne(t.toDocumentVentasProductos());
            JOptionPane.showMessageDialog(null, "Venta Generada de Manera Correcta", "Correcto", JOptionPane.INFORMATION_MESSAGE);
        } catch (MongoException e) {
        }
    }

    @Override
    public MongoCollection<Document> findAll() {
        return ventasProdcuts.getCollectionData();
    }

    @Override
    public void deleteByName(String name) {
        try {
            ventasProdcuts.getCollectionData().deleteOne(Filters.eq("fecha", name));
        } catch (MongoException e) {
        }
    }

    @Override
    public void deleteById(String name) {
        try {
            ventasProdcuts.getCollectionData().deleteOne(Filters.eq("cliente", name));
        } catch (MongoException e) {
        }
    }

    @Override
    public void updateByName(String t, VentasProductos a) {
        try {
            ventasProdcuts.getCollectionData().updateOne(Filters.eq("fecha", t), new Document("$set", a.toDocumentVentasProductos()));
        } catch (MongoException e) {
        }
    }

    @Override
    public void updateById(String t, VentasProductos a) {
        try {
            ventasProdcuts.getCollectionData().updateOne(Filters.eq("cliente", t), new Document("$set", a.toDocumentVentasProductos()));
        } catch (MongoException e) {
        }
    }

    @Override
    public Document findByName(String t) {
        return ventasProdcuts.getCollectionData().find(Filters.eq("fecha", t)).first();
    }

    @Override
    public Document findById(String t) {
        return ventasProdcuts.getCollectionData().find(Filters.eq("cliente", t)).first();

    }

}
