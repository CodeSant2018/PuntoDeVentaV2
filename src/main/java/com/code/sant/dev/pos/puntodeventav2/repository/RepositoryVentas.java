/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.code.sant.dev.pos.puntodeventav2.repository;

import com.mongodb.client.MongoCollection;
import java.util.Date;
import org.bson.Document;


public interface RepositoryVentas <T> {
    
    void crear(T t);

    MongoCollection<Document> findAll();

    void delete(Date t);

    void update(String t, T a);

    Document findByDate(String t);
    
           
}
