/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Org.proyecto.system.controller.FarmaciaController;

import Org.proyecto.system.conexion.ConexionDB;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Random;

/**
 *
 * @author Javier
 */
public class AgregarMedicamentoController {

    public AgregarMedicamentoController() {
    }
    
    public static void AgregarMedicamento(String nombreMedicina, int cantidad, String descripcion,double precio){
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConexionDB.getConnection(); 
            stmt = conn.prepareCall("{CALL sp_crearMedicina(?, ?, ?, ?, ?)}");

            Random random = new Random();
            int idMedicina = random.nextInt(10000);

            stmt.setInt(1, idMedicina);
            stmt.setString(2, nombreMedicina);
            stmt.setInt(3, cantidad);
            stmt.setString(4, descripcion);
            stmt.setDouble(5, precio);

            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Error al agregar el Medicamento: " + e.getMessage());
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
