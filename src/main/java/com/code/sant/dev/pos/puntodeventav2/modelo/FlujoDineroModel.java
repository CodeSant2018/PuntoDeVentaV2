/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.code.sant.dev.pos.puntodeventav2.modelo;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bson.Document;

@Getter
@Setter
@AllArgsConstructor
public class FlujoDineroModel {
    
    private Date date;
    private String hour;
    private double quantity;
    private String tipe;
    
    public Document toFlowMoney(){
        return new Document("Date",date)
                .append("Hours", hour)
                .append("Quantity", quantity)
                .append("Tipe", tipe);
    }
}
