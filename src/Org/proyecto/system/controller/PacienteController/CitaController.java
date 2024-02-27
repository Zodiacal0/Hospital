package Org.proyecto.system.controller.PacienteController;

import Org.proyecto.system.conexion.ConexionDB;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Time;
import java.util.Random;

public class CitaController {
    public static void AgendarCita(String motivo, String especialidadRequerida,String doctorRequerido, Date fecha, Time hora,String fechaStr) { 
        Connection conn = null;
        CallableStatement cstmt = null;
        
        try {
            conn = ConexionDB.getConnection();
            String storedProcedure = "{CALL sp_crearCita(?, ?, ?, ?, ?, ?, ?)}";
            cstmt = conn.prepareCall(storedProcedure);
            
            Random rand = new Random();
            int idCita = rand.nextInt(9999) + 1;
            String estado = "Pendiente";
            
            cstmt.setInt(1, idCita);
            cstmt.setString(2, motivo);
            cstmt.setString(3, especialidadRequerida);
            cstmt.setString(4, doctorRequerido);
            cstmt.setDate(5, fecha);
            cstmt.setTime(6, hora);
            cstmt.setString(7, estado);
            
            cstmt.execute();
            
            System.out.println("La cita se ha agendado correctamente.");
        } catch (SQLException ex) {
            System.out.println("Error al agendar la cita: " + ex.getMessage());
        } finally {
            try {
                if (cstmt != null) {
                    cstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexión: " + ex.getMessage());
            }
        }
    }
}
