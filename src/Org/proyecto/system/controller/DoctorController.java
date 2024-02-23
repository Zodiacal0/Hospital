/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Org.proyecto.system.controller;
import java.sql.*;
import java.util.Random;
/**
 *
 * @author Javier
 */
public class DoctorController {

    public DoctorController() {
    }
    
    public static void AgregarDoctor(String nombre, String apellido, String genero, int edad, String especialidad, int telefono, String contraseña) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB_ProyectoHospital", "root", "Aurorita0306@");
            CallableStatement stmt = conn.prepareCall("{CALL sp_agregarDoctor(?, ?, ?, ?, ?, ?, ?, ?)}");

            Random random = new Random();
            int idDoctor = random.nextInt(10000);

            stmt.setInt(1, idDoctor);
            stmt.setString(2, nombre);
            stmt.setString(3, apellido);
            stmt.setString(4, especialidad);
            stmt.setString(5, genero);
            stmt.setInt(6, edad);
            stmt.setInt(7, telefono);
            stmt.setString(8, contraseña);

            stmt.execute();
            stmt.close();
            conn.close();
            
        } catch (SQLException e) {
            System.out.println("Error al agregar doctor: " + e.getMessage());
        }
    }

    
}
