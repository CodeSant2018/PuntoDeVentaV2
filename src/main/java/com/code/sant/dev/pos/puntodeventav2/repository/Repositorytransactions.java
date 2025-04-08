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
public interface Repositorytransactions<T> {

    void crear(T t);

    MongoCollection<Document> findAll();

    void deleteByName(String name);

    void deleteById(String name);

    void updateByName(String t, T a);

    void updateById(String t, T a);

    Document findByName(String t);

    Document findById(String t);
}
