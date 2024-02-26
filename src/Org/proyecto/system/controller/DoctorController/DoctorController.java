/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Org.proyecto.system.controller.DoctorController;
import Org.proyecto.system.conexion.ConexionDB;
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
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConexionDB.getConnection(); 
            stmt = conn.prepareCall("{CALL sp_agregarDoctor(?, ?, ?, ?, ?, ?, ?, ?)}");

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
        } catch (SQLException e) {
            System.out.println("Error al agregar doctor: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }


    
}
