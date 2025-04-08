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
public interface RepositoryClientes<T> {

    void crear(T t);

    MongoCollection<Document> findAll();

    void delete(String t);

    void update(String t, T a);

    Document findByName(String t);
}
