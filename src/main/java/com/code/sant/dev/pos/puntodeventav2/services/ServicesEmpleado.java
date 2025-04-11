/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.code.sant.dev.pos.puntodeventav2.services;

import com.code.sant.dev.pos.puntodeventav2.entity.GestionData;
import com.code.sant.dev.pos.puntodeventav2.modelo.Empleado;
import com.code.sant.dev.pos.puntodeventav2.repository.Repositorytransactions;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import javax.swing.JOptionPane;
import org.bson.Document;

/**
 *
 * @author codesant
 */
public class ServicesEmpleado implements Repositorytransactions<Empleado> {

    private GestionData empleado = new GestionData("Empleados");

    @Override
    public void crear(Empleado t) {
        try {
            empleado.getCollectionData().insertOne(t.toDocumentEmpleado());
            JOptionPane.showMessageDialog(null, "Empleado Ingresado de Manera Correcta", "Correcto", JOptionPane.INFORMATION_MESSAGE);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public MongoCollection<Document> findAll() {

        try {
            return empleado.getCollectionData();
        } catch (MongoException e) {
            e.printStackTrace();
        }

        return empleado.getCollectionData();
    }

    @Override
    public void deleteByName(String name) {
        try {
            empleado.getCollectionData().deleteOne(Filters.eq("Nombre", name));
            JOptionPane.showMessageDialog(null, "Empleado Eliminado de Manera Correcta", "Correcto", JOptionPane.INFORMATION_MESSAGE);

        } catch (MongoException e) {
        }
    }

    @Override
    public void deleteById(String name) {
        try {
            empleado.getCollectionData().deleteOne(Filters.eq("Id_Empleado", name));
            JOptionPane.showMessageDialog(null, "Empleado Eliminado de Manera Correcta", "Correcto", JOptionPane.INFORMATION_MESSAGE);

        } catch (MongoException e) {
        }
    }

    @Override
    public void updateByName(String t, Empleado a) {
        try {
            empleado.getCollectionData().updateOne(Filters.eq("Nombre", t), new Document("$set", a.toDocumentEmpleado()));
            JOptionPane.showMessageDialog(null, "Empleado Actualizado de Manera Correcta", "Correcto", JOptionPane.INFORMATION_MESSAGE);

        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateById(String t, Empleado a) {
        try {
            empleado.getCollectionData().updateOne(Filters.eq("Id_Empleado", t), new Document("$set", a.toDocumentEmpleado()));
            JOptionPane.showMessageDialog(null, "Empleado Actualizado de Manera Correcta", "Correcto", JOptionPane.INFORMATION_MESSAGE);

        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Document findByName(String t) {
        return empleado.getCollectionData().find(Filters.eq("Nombre", t)).first();
    }

    @Override
    public Document findById(String t) {
        return empleado.getCollectionData().find(Filters.eq("Id_Empleado", t)).first();
    }

}
