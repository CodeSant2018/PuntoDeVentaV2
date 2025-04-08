/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.code.sant.dev.pos.puntodeventav2.entity;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author codesant
 */
public class GestionData {

    private String collecion;
    private ReformaData reformaData;
    private MongoDatabase data;
    private MongoCollection<Document> collection;

    public GestionData(String collecion) {
        this.collecion = collecion;
    }

    public MongoCollection<Document> getCollectionData() {

        reformaData = ReformaData.getInstance();
        data = reformaData.getData();
        collection = data.getCollection(this.collecion);
        
        return collection;
    }

}
