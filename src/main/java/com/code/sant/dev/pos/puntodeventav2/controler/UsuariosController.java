/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.code.sant.dev.pos.puntodeventav2.controler;

import com.code.sant.dev.pos.puntodeventav2.modelo.UsuariosModel;
import com.code.sant.dev.pos.puntodeventav2.repository.RepositoryPerson;
import com.code.sant.dev.pos.puntodeventav2.services.UsuarioServices;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

/**
 *
 * @author codesant
 */
public class UsuariosController implements RepositoryPerson<UsuariosModel>{
    
    private UsuarioServices uS = new UsuarioServices();

    @Override
    public MongoCollection<Document> getAll() {
        return uS.getAll();
    }

    @Override
    public Document findById(String id) {
        return uS.findById(id);
    }

    @Override
    public Document findByName(String personName) {
        return uS.findByName(personName);
    }

    @Override
    public void create(UsuariosModel person) {
        uS.create(person);
    }

    @Override
    public void deleteByName(String personName) {
        uS.deleteByName(personName);
    }

    @Override
    public void deleteById(String id) {
        uS.deleteByName(id);
    }

    @Override
    public void updateByName(String personName, UsuariosModel doc) {
        uS.updateByName(personName, doc);
    }
    
}
