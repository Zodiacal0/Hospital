/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Org.proyecto.system.models;

/**
 *
 * @author Javier
 */
public class Paciente {

    public Paciente() {
    }
    
    private String nombres;
    private String apellidos;
    private int edad;
    private char sexo;
    private String contrasena;

    public Paciente(String nombres, String apellidos, int edad, char sexo, String contrasena) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.sexo = sexo;
        this.contrasena = contrasena;
    }
    
    
    
}
