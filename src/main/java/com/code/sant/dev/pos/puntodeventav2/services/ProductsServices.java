/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.code.sant.dev.pos.puntodeventav2.services;

import com.code.sant.dev.pos.puntodeventav2.entity.ReformaData;
import com.code.sant.dev.pos.puntodeventav2.modelo.ProductosModel;
import com.code.sant.dev.pos.puntodeventav2.repository.RepositoryReforma;
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
public class ProductsServices implements RepositoryReforma<ProductosModel> {

    private ReformaData rD = ReformaData.getInstance();
    private MongoDatabase data = rD.getData();
    private MongoCollection<Document> coll = data.getCollection("Productos");

    @Override
    public MongoCollection<Document> getAll() {
        return coll;
    }

    @Override
    public Document findById(String id) {
        try {
            return coll.find(Filters.eq("Id", id)).first();
        } catch (MongoException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al buscar: " + id, "Error", JOptionPane.ERROR_MESSAGE);
            return null; // Retorna null en caso de error
        }
    }

    @Override
    public Document findByName(String productName) {
        try {
            return coll.find(Filters.eq("Nombre", productName)).first();
        } catch (MongoException e) {

            return null;
        }
    }

    @Override
    public void create(ProductosModel doc) {
        try {
            coll.insertOne(doc.toProduct());
            JOptionPane.showMessageDialog(null, "Producto: " + doc.getName() +" \nIngresado de manera correcta", "Correcto", JOptionPane.INFORMATION_MESSAGE);

        } catch (MongoException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al ingresar el Producto: " + doc.getName(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    @Override
    public void deleteByName(String productName) {
        try {
            coll.deleteOne(Filters.eq("Nombre",productName));
        } catch (MongoException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al eliminar: " + productName, "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    @Override
    public void deleteById(String id) {
        try {
            coll.deleteOne(Filters.eq("Id",id));
        } catch (MongoException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al eliminar: " + id, "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    @Override
    public void updateByName(String productName, ProductosModel doc) {
        try {
            coll.updateOne(Filters.eq("Nombre",productName), new Document("$set", doc.toProduct()));
        } catch (MongoException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al actualizar: " + productName, "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    @Override
    public void updateById(String id, ProductosModel doc) {
         try {
            coll.updateOne(Filters.eq("Id",id), new Document("$set", doc.toProduct()));
        } catch (MongoException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al actualizar: " + id, "Error", JOptionPane.ERROR_MESSAGE);

        }
    }
}
