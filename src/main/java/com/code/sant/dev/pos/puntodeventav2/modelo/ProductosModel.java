
package com.code.sant.dev.pos.puntodeventav2.modelo;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;


@Getter
@Setter

public class ProductosModel {
    
    private String id;
    private String categoria;
    private String name;
    private String description;
    private double price;
    private double priceFinal;
    private int quantity;
    
    public ProductosModel(String id, String categoria,String name,String description,double price,double priceFinal,int quantity){
        this.id = id;
        this.categoria=categoria;
        this.name = name;
        this.description=description;
        this.price = price;
        this.priceFinal = priceFinal;
        this.quantity = quantity;
    }
    
    
    public Document toProduct(){
        return new Document("Id",id)
                .append("Categoría", categoria)
                .append("Nombre", name)
                .append("Descripción", description)
                .append("Precio", price)
                .append("Precio Venta", priceFinal)
                .append("Cantidad", quantity);
    }
    
    
}
