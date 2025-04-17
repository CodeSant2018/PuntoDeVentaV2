/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.code.sant.dev.pos.puntodeventav2.services;

import com.code.sant.dev.pos.puntodeventav2.entity.GestionData;
import com.code.sant.dev.pos.puntodeventav2.modelo.Proveedor;
import com.code.sant.dev.pos.puntodeventav2.repository.RepositoryClientes;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

/**
 *
 * @author thevoid
 */
public class ServicesProveedor implements RepositoryClientes<Proveedor>{
    
    private GestionData proveedores = new GestionData("Proveedores");

    @Override
    public void crear(Proveedor t) {
        proveedores.getCollectionData().insertOne(t.toDocumentProveedor());
    }

    @Override
    public MongoCollection<Document> findAll() {
        return proveedores.getCollectionData();
    }

    @Override
    public void delete(String t) {
        proveedores.getCollectionData().deleteOne(Filters.eq("Nombre_Proveedor",t));
    }

    @Override
    public void update(String t, Proveedor a) {
        proveedores.getCollectionData().updateOne(Filters.eq("Nombre_Proveedor", a),new Document("$set",a.toDocumentProveedor()));
    }

    @Override
    public Document findByName(String t) {
        return proveedores.getCollectionData().find(Filters.eq("Nombre_Proveedor",t)).first();
    }

    
}
