/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.code.sant.dev.pos.puntodeventav2.repository;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

/**
 *
 * @author codesant
 */
public interface RepositoryTransaction <T> {
     MongoCollection<Document> getAll();
    
    Document findById(String id);
    
    Document findByName(String clientName);
    
    void create(T person);
    
    void deleteByName(String clientName);
    
    void deleteById(String id);
    
    void updateByName(String clientName,T doc);
}
