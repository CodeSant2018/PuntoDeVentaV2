/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.code.sant.dev.pos.puntodeventav2.services;

import com.code.sant.dev.pos.puntodeventav2.entity.ReformaData;
import com.code.sant.dev.pos.puntodeventav2.modelo.UsuariosModel;
import com.code.sant.dev.pos.puntodeventav2.repository.RepositoryPerson;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import javax.swing.JOptionPane;
import org.bson.Document;

/**
 *
 * @author codesant
 */
public class UsuarioServices implements RepositoryPerson<UsuariosModel> {

    private ReformaData reform = ReformaData.getInstance();
    private MongoDatabase data = reform.getData();
    private MongoCollection<Document> coll = data.getCollection("Usuarios");

    @Override
    public MongoCollection<Document> getAll() {
        return coll;
    }

    @Override
    public Document findById(String id) {
        try {
            return coll.find(Filters.eq("id", id)).first();

        } catch (MongoException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    @Override
    public Document findByName(String personName) {
        try {
            return coll.find(Filters.eq("Usuario", personName)).first();

        } catch (MongoException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);

            return null;
        }
    }

        @Override
    public void create(UsuariosModel person) {
        try {
            coll.insertOne(person.toUser());
            JOptionPane.showMessageDialog(null, "Usuario Ingresado");
        } catch (MongoException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    @Override
    public void deleteByName(String personName) {
        try {
            coll.deleteOne(Filters.eq("Usuario", personName));
        } catch (MongoException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    @Override
    public void deleteById(String id) {
        try {
            coll.deleteOne(Filters.eq("id", id));
        } catch (MongoException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    @Override
    public void updateByName(String personName, UsuariosModel doc) {
        try {
            coll.updateOne(Filters.eq("id", personName), new Document("$set", doc.toUser()));
        } catch (MongoException e) {
        }
    }

}
