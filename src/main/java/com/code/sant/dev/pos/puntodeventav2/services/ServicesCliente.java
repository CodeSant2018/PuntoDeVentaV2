/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.code.sant.dev.pos.puntodeventav2.services;

import com.code.sant.dev.pos.puntodeventav2.entity.GestionData;
import com.code.sant.dev.pos.puntodeventav2.modelo.Cliente;
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
public class ServicesCliente implements RepositoryClientes<Cliente> {

    private GestionData clientes = new GestionData("Clientes");

    @Override
    public void crear(Cliente t) {
        try {
            clientes.getCollectionData().insertOne(t.toDocumentCliente());
            JOptionPane.showMessageDialog(null, "Cliente Ingresado de Manera Correta!", "Correcto", JOptionPane.INFORMATION_MESSAGE);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public MongoCollection<Document> findAll() {
        return clientes.getCollectionData();
    }

    @Override
    public void delete(String t) {
        try {
            clientes.getCollectionData().deleteOne(Filters.eq("Nombre", t));
            JOptionPane.showMessageDialog(null, "Cliente Eliminado de Manera Correta!", "Correcto", JOptionPane.INFORMATION_MESSAGE);
        } catch (MongoException e) {
        }
    }

    @Override
    public void update(String t, Cliente a) {
        try {
            clientes.getCollectionData().updateOne(Filters.eq("Nombre", t), new Document("$set", a.toDocumentCliente()));
            JOptionPane.showMessageDialog(null, "Cliente Actualizado de Manera Correta!", "Correcto", JOptionPane.INFORMATION_MESSAGE);

        } catch (MongoException e) {
        }
    }

    @Override
    public Document findByName(String t) {
        return clientes.getCollectionData().find(Filters.eq("Nombre",t)).first();
    }
}
