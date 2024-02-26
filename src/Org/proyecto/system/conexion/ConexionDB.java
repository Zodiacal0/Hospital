/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Org.proyecto.system.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Javier
 */
public class ConexionDB {
    private static Connection conn;

    static {
        try {
            // Cargar explícitamente el controlador JDBC de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión a la base de datos
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB_ProyectoHospital", "root", "Aurorita0306@");
         } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al establecer la conexión: " + e.getMessage());
        }
    }

    public static Connection getConnection() {
        return conn;
    }
}
