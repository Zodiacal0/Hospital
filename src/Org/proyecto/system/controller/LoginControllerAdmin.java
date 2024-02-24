/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Org.proyecto.system.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Javier
 */
public class LoginControllerAdmin {

    public LoginControllerAdmin() {
    }
    
    public static boolean Validacion(String username, String pass){
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB_ProyectoHospital", "root", "Aurorita0306@");
            PreparedStatement stmt = conn.prepareStatement("CALL sp_validacion(?,?)");
            stmt.setString(1, username);
            stmt.setString(2, pass);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            return count > 0; /*Cuando se manda a llamar el prcedimiento si arroja un valor arriba de 0 es que si existe el user*/
        }catch(SQLException e) {
            System.out.println("Error al verificar las credenciales: " + e.getMessage());
            return false;
        }
    }
}

