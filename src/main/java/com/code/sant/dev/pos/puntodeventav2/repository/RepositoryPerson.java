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
public interface RepositoryPerson <T> {
    MongoCollection<Document> getAll();
    
    Document findById(String id);
    
    Document findByName(String personName);
    
    void create(T person);
    
    void deleteByName(String personName);
    
    void deleteById(String id);
    
    void updateByName(String personName,T doc);
    

}
