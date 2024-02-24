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
import javax.swing.JOptionPane;

/**
 *
 * @author Javier
 */
public class EliminarDoctorController {

    public EliminarDoctorController() {
    }
    
    public static boolean Eliminar(int idDoc,String nombreDoc,String passAdmin){
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB_ProyectoHospital", "root", "Aurorita0306@");

            CallableStatement stmtValidacion = conn.prepareCall("{CALL sp_eliminarDoctor(?, ?)}"); /*Busca Variables en la DB*/
            stmtValidacion.setInt(1, idDoc);
            stmtValidacion.setString(2, nombreDoc);
            boolean hasResultSetValidacion = stmtValidacion.execute();

            int countValidacion = 0;
            if (hasResultSetValidacion) {
                ResultSet rsValidacion = stmtValidacion.getResultSet();
                if (rsValidacion.next()) {
                    countValidacion = rsValidacion.getInt(1);
                }
            }

            CallableStatement stmtValidarPass = conn.prepareCall("{CALL sp_validacionAdminPass(?)}"); /*Validación extra*/
            stmtValidarPass.setString(1, passAdmin);
            boolean hasResultSetValidarBorrado = stmtValidarPass.execute();

            int countValidarBorrado = 0;
            if (hasResultSetValidarBorrado) {
                ResultSet rsValidarBorrado = stmtValidarPass.getResultSet();
                if (rsValidarBorrado.next()) {
                    countValidarBorrado = rsValidarBorrado.getInt(1);
                }
            }

            if (countValidacion > 0 && countValidarBorrado > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar las credenciales: " + e.getMessage());
            
            return false;
        }
    }   
}
