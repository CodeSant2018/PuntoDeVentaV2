
package com.code.sant.dev.pos.puntodeventav2.entity;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class ReformaData {
    
    private static ReformaData instance;
    private MongoClient cliente;
    private MongoDatabase data;
    
    private ReformaData(){
        cliente = MongoClients.create("mongodb://localhost:27017");
        data = cliente.getDatabase("Reforma");
    }
    
    public static synchronized ReformaData getInstance(){
        if(instance == null){
            instance = new ReformaData();
        }
        return instance;
    }
    
    public MongoDatabase getData(){
        return data;
    }
    
    public void close(){
        cliente.close();
    }
    
    
}
