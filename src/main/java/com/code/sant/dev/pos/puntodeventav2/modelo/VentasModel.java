/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.code.sant.dev.pos.puntodeventav2.modelo;

import java.util.List;
import java.util.Random;
import lombok.*;
import org.bson.Document;

@Getter
@Setter
@AllArgsConstructor
public class VentasModel {
    
    private String id;
    private String date;
    private String client;
    private List<Document> product;
    private double earnings;
    private double salesTotal;

    public VentasModel(String date, String client, List<Document> product, double earnings, double salesTotal) {
        this.id = String.valueOf(idGerator());
        this.date = date;
        this.client = client;
        this.product = product;
        this.earnings = earnings;
        this.salesTotal = salesTotal;
    }
    
    
    
    public Document toSales(){
        return  new Document("Id",id)
                .append("date", this.date)
                .append("client", client)
                .append("products", product)
                .append("earnings", earnings)
                .append("salesTotal", this.salesTotal);
    }
    
       public int idGerator(){
        Random rm = new Random();
        return rm.nextInt(1000000000);
    }
}
