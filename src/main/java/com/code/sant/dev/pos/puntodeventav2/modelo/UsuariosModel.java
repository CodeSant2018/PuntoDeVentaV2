
package com.code.sant.dev.pos.puntodeventav2.modelo;
import java.util.Date;
import java.util.Random;
import lombok.Getter;
import lombok.Setter;
import org.bson.Document;


@Getter
@Setter
public class UsuariosModel {
    
    private String id;
    private String user;
    private String name;
    private String email;
    private String password;
    private String date;

    public UsuariosModel(String user, String name, String email, String password, String date) {
        this.id = String.valueOf(idGerator());
        this.user = user;
        this.name = name;
        this.email = email;
        this.password = password;
        this.date = date;
    }  
    
    public int idGerator(){
        Random rm = new Random();
        return rm.nextInt(1000000000);
    }
    
    public Document toUser(){
        return new Document("id",id)
                .append("Usuario", user)
                .append("Nombre", name)
                .append("Correo", email)
                .append("Contraseña", password)
                .append("Fecha", date);
    }
}
