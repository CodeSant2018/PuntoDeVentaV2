/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.code.sant.dev.pos.puntodeventav2.modelo;

import java.util.Random;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bson.Document;

@Getter
@Setter
@AllArgsConstructor

public class CorteCajaModel {

    private String id;
    private Data date;
    private String user;
    private FlujoDineroModel flowMoney;
    private double totalSale;
    private double earnings;

    public CorteCajaModel(Data date, String user, double totalSale, double earnings) {
        this.id = String.valueOf(idGerator());
        this.date = date;
        this.user = user;
        this.totalSale = totalSale;
        this.earnings = earnings;
    }
    
    public Document toFinalDayDocument() {
        return new Document("Id", id)
                .append("Date", date)
                .append("User", user)
                .append("FlowMoney", flowMoney.toFlowMoney())
                .append("Total-Sale", totalSale)
                .append("Earnings", earnings);
    }

    public int idGerator() {
        Random rm = new Random();
        return rm.nextInt(1000000000);
    }

}
