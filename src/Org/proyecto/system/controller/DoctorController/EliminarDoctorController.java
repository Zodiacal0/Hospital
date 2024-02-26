/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Org.proyecto.system.controller.DoctorController;

import Org.proyecto.system.conexion.ConexionDB;
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
    
    public static boolean Eliminar(int idDoc, String nombreDoc, String passAdmin) {
        Connection conn = null;
        CallableStatement stmtValidacion = null;
        CallableStatement stmtValidarPass = null;

        try {
            conn = ConexionDB.getConnection(); 

            stmtValidacion = conn.prepareCall("{CALL sp_eliminarDoctor(?, ?)}");
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

            stmtValidarPass = conn.prepareCall("{CALL sp_validacionAdminPass(?)}");
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
        } finally {
            try {
                if (stmtValidacion != null) {
                    stmtValidacion.close();
                }
                if (stmtValidarPass != null) {
                    stmtValidarPass.close();
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
