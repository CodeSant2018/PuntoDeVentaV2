/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.code.sant.dev.pos.puntodeventav2.controler;

import com.code.sant.dev.pos.puntodeventav2.modelo.ProductosModel;
import com.code.sant.dev.pos.puntodeventav2.repository.RepositoryReforma;
import com.code.sant.dev.pos.puntodeventav2.services.ProductsServices;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

/**
 *
 * @author codesant
 */
public class ProductsController implements RepositoryReforma<ProductosModel>{
    
    private ProductsServices ps = new ProductsServices();

    @Override
    public MongoCollection<Document> getAll() {
        return ps.getAll();
    }

    @Override
    public Document findById(String id) {
        return ps.findById(id);
    }

    @Override
    public Document findByName(String productName) {
        return ps.findByName(productName);
    }

    @Override
    public void create(ProductosModel doc) {
        ps.create(doc);
    }

    @Override
    public void deleteByName(String productName) {
        ps.deleteByName(productName);
    }

    @Override
    public void deleteById(String id) {
        ps.deleteById(id);
    }

    @Override
    public void updateByName(String productName, ProductosModel doc) {
        ps.updateByName(productName, doc);
    }

    @Override
    public void updateById(String id, ProductosModel doc) {
        ps.updateById(id, doc);
    }
    
}
