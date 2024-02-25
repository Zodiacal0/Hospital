/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Org.proyecto.system.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Javier
 */
public class ActualizarDoctorController {

    public ActualizarDoctorController() {
    }
    
    public static boolean ActualizarDoctor(int idDoctor,String nombre,String apellido,String especialidad,int edad,int telefono, String contraseña){
        try(Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB_ProyectoHospital", "root", "Aurorita0306@")) {
            CallableStatement stmtActualizar = cnn.prepareCall("CALL sp_actualizarDoctores(?,?,?,?,?,?,?)");

            stmtActualizar.setInt(1, idDoctor);
            stmtActualizar.setString(2, nombre);
            stmtActualizar.setString(3, apellido);
            stmtActualizar.setString(4, especialidad);
            stmtActualizar.setInt(5, edad);
            stmtActualizar.setInt(6, telefono);
            stmtActualizar.setString(7, contraseña);

            if (stmtActualizar.executeUpdate() > 0){
                return true;
            }else{
                return false;
            }
        } catch(SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        return false;
        }
    }
}
