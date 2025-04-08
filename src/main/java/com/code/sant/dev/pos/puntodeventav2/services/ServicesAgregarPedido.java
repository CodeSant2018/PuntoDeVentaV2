/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.code.sant.dev.pos.puntodeventav2.services;

import com.code.sant.dev.pos.puntodeventav2.entity.GestionData;
import com.code.sant.dev.pos.puntodeventav2.modelo.AgregarPedido;
import com.code.sant.dev.pos.puntodeventav2.repository.RepositoryClientes;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import javax.swing.JOptionPane;
import org.bson.Document;

/**
 *
 * @author codesant
 */
public class ServicesAgregarPedido implements RepositoryClientes<AgregarPedido> {

    private GestionData pedido = new GestionData("Agregar_Pedido");

    @Override
    public void crear(AgregarPedido t) {
        try {
            pedido.getCollectionData().insertOne(t.toDocumentAgregarPedido());
            JOptionPane.showMessageDialog(null, "Pedido Registrado", "Correcto", JOptionPane.INFORMATION_MESSAGE);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public MongoCollection<Document> findAll() {
        return pedido.getCollectionData();
    }

    @Override
    public void delete(String t) {
        try {
            pedido.getCollectionData().deleteOne(Filters.eq("nombre", t));
            JOptionPane.showMessageDialog(null, "Pedido Eliminado", "Correcto", JOptionPane.INFORMATION_MESSAGE);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String t, AgregarPedido a) {
        try{
            pedido.getCollectionData().updateOne(Filters.eq("nombre",t), new Document("$set",a.toDocumentAgregarPedido()));
        }catch(MongoException e){
            e.printStackTrace();
        }
    }

    @Override
    public Document findByName(String t) {
        return pedido.getCollectionData().find(Filters.eq("nombre",t)).first();
    }

}
