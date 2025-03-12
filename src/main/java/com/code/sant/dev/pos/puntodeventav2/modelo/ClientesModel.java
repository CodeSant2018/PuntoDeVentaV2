/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.code.sant.dev.pos.puntodeventav2.modelo;

import com.mongodb.annotations.Sealed;
import java.util.Date;
import java.util.Random;
import lombok.Getter;
import lombok.Setter;
import org.bson.Document;

@Getter
@Setter
public class ClientesModel {
    
    private String id;
    private String name;
    private String phone;
    private String location;
    private Date date;

    public ClientesModel(String name, String phone, String location, Date date) {
        this.id = String.valueOf(idGenerator());
        this.name = name;
        this.phone = phone;
        this.location = location;
        this.date = date;
    }
 
    public int idGenerator(){
        Random rm = new Random();
        return rm.nextInt(10000);
    }
   

    public Document toClient(){
        return new Document("id",id)
                .append("Nombre", name)
                .append("Telefono", phone)
                .append("Dirección", location)
                .append("Fecha", date);
    }
}
