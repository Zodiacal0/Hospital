/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Org.proyecto.system.controller.DoctorController;

import Org.proyecto.system.conexion.ConexionDB;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Javier
 */
public class AceptarRechazarCitas {
    public static boolean AceptarDenegar(int idDoc) {
        Connection conn = null;
        CallableStatement stmtValidacion = null;

        try {
            conn = ConexionDB.getConnection(); 

            stmtValidacion = conn.prepareCall("{CALL sp_eliminarCita(?)}");
            stmtValidacion.setInt(1, idDoc);
            boolean hasResultSetValidacion = stmtValidacion.execute();

            int countValidacion = 0;
            if (hasResultSetValidacion) {
                ResultSet rsValidacion = stmtValidacion.getResultSet();
                if (rsValidacion.next()) {
                    countValidacion = rsValidacion.getInt(1);
                }
            }

            if (countValidacion > 0) {
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
            } catch (SQLException e) {
                System.out.println("Error al cerrar el CallableStatement: " + e.getMessage());
            }
        }
    }
}
