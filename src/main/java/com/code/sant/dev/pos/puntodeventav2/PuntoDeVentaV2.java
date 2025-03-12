/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.code.sant.dev.pos.puntodeventav2;
import com.code.sant.dev.pos.puntodeventav2.vista.Loging;
import com.code.sant.dev.pos.puntodeventav2.vista.VentasPanel;
import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import javax.swing.UIManager;

/**
 *
 * @author codesant
 */
public class PuntoDeVentaV2 {

    public static void main(String[] args) {
        FlatArcIJTheme.setup();
        UIManager.put("Button.arc", 20);
        UIManager.put("Component.arc", 10);
        UIManager.put("ProgressBar.arc", 20);
        UIManager.put("TextComponent.arc", 10);
        /*Usuarios u = new Usuarios();
        u.setVisible(true);
        u.setLocationRelativeTo(null);*/
      
         VentasPanel p = new VentasPanel();
        p.setVisible(true);
        p.setLocationRelativeTo(null);
         /*Usuarios p = new Usuarios();
         p.setVisible(true);*/
        
        
        // Crear y mostrar el JFrame con el tema específico
       
        
    }
}
