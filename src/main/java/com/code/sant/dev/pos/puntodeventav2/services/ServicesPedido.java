/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.code.sant.dev.pos.puntodeventav2.services;

import com.code.sant.dev.pos.puntodeventav2.entity.GestionData;
import com.code.sant.dev.pos.puntodeventav2.modelo.Pedido;
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
public class ServicesPedido implements Repositorytransactions<Pedido> {

    private GestionData pedido = new GestionData("Pedidos");

    @Override
    public void crear(Pedido t) {
        try {
            pedido.getCollectionData().insertOne(t.toDocumentPedido());
            JOptionPane.showMessageDialog(null, "Pedido Ingresado de Manera Correcta", "Correcto", JOptionPane.INFORMATION_MESSAGE);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public MongoCollection<Document> findAll() {
        return pedido.getCollectionData();
    }

    @Override
    public void deleteByName(String name) {
        try {
            pedido.getCollectionData().deleteOne(Filters.eq("Proveedor", name));
            JOptionPane.showMessageDialog(null, "Pedido Ingresado de Manera Correcta", "Correcto", JOptionPane.INFORMATION_MESSAGE);

        } catch (MongoException e) {
        }
    }

    @Override
    public void deleteById(String name) {
        try {
            pedido.getCollectionData().deleteOne(Filters.eq("Id_Proveedor", name));
            JOptionPane.showMessageDialog(null, "Pedido Ingresado de Manera Correcta", "Correcto", JOptionPane.INFORMATION_MESSAGE);

        } catch (MongoException e) {
        }
    }

    @Override
    public void updateByName(String t, Pedido a) {
        try {
            pedido.getCollectionData().updateOne(Filters.eq("Proveedor", t), new Document("$set", a.toDocumentPedido()));
            JOptionPane.showMessageDialog(null, "Pedido Actualizado de Manera Correcta", "Correcto", JOptionPane.INFORMATION_MESSAGE);

        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateById(String t, Pedido a) {
        try {
            pedido.getCollectionData().updateOne(Filters.eq("Id_Proveedor", t), new Document("$set", a.toDocumentPedido()));
            JOptionPane.showMessageDialog(null, "Pedido Actualizado de Manera Correcta", "Correcto", JOptionPane.INFORMATION_MESSAGE);

        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Document findByName(String t) {
        return pedido.getCollectionData().find(Filters.eq("Proveedor", t)).first();
    }

    @Override
    public Document findById(String t) {
        return pedido.getCollectionData().find(Filters.eq("Id_Proveedor", t)).first();
    }

}
