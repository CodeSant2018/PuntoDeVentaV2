/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.code.sant.dev.pos.puntodeventav2.services;

import com.code.sant.dev.pos.puntodeventav2.entity.GestionData;
import com.code.sant.dev.pos.puntodeventav2.modelo.Inventario;
import com.code.sant.dev.pos.puntodeventav2.repository.Repositorytransactions;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import javax.swing.JOptionPane;
import org.bson.Document;

/**
 *
 * @author codesant
 */
public class ServicesInventario implements Repositorytransactions<Inventario> {

    private GestionData inventario = new GestionData("Inventario");

    @Override
    public void crear(Inventario t) {
        try {
            inventario.getCollectionData().insertOne(t.toDocumentInventario());
            JOptionPane.showMessageDialog(null, "¡Producto agregado exitosamente!", "Correcto", JOptionPane.INFORMATION_MESSAGE);

        } catch (MongoException e) {
        }
    }

    @Override
    public MongoCollection<Document> findAll() {
        return inventario.getCollectionData();
    }

    @Override
    public void deleteByName(String name) {
        try {
            inventario.getCollectionData().deleteOne(Filters.eq("nombre", name));
            JOptionPane.showMessageDialog(null, "Producto Eliminado de Manera Correta!", "Correcto", JOptionPane.INFORMATION_MESSAGE);

        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(String name) {
        try {
            inventario.getCollectionData().deleteOne(Filters.eq("id_Producto", name));
            JOptionPane.showMessageDialog(null, "Producto Eliminado de Manera Correta!", "Correcto", JOptionPane.INFORMATION_MESSAGE);

        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateByName(String t, Inventario a) {
        try {
            inventario.getCollectionData().updateOne(Filters.eq("nombre", t), new Document("$set", a.toDocumentInventario()));
            JOptionPane.showMessageDialog(null, "Producto Actualizado de Manera Correta!", "Correcto", JOptionPane.INFORMATION_MESSAGE);

        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateById(String t, Inventario a) {
        try {
            inventario.getCollectionData().updateOne(Filters.eq("id_Producto", t), new Document("$set", a.toDocumentInventario()));
            JOptionPane.showMessageDialog(null, "Producto Actualizado de Manera Correta!", "Correcto", JOptionPane.INFORMATION_MESSAGE);

        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Document findByName(String t) {
        return inventario.getCollectionData().find(Filters.eq("nombre",t)).first();
    }

    @Override
    public Document findById(String t) {
        return inventario.getCollectionData().find(Filters.eq("id_Producto",t)).first();
    }

}
