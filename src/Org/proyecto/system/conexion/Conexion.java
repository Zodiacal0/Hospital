/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Org.proyecto.system.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javier
 */
public class Conexion {

    public Conexion() {
    }
    
    Connection conexion;
    
    public Connection ConexionSql(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB_ProyectoHospital","root","Aurorita0306@"); /*root (usuario) Aurorita0306 (password) Cambiar en cada caso*/
        }catch(ClassNotFoundException |SQLException  e){
            System.out.println("Error: " + e.getMessage());
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,e);
        }
        return conexion;
    }
}
