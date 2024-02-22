/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Org.proyecto.system.models;

/**
 *
 * @author Javier
 */
public class Doctor {

    public Doctor() {
    }
    
    private String nombres;
    private String apellidos;
    private String especialidad;
    private String contrasena;
    private char sexo;
    private int edad;
    private int telefono;

    public Doctor(String nombres, String apellidos, String especialidad, String contrasena, char sexo, int edad, int telefono) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.especialidad = especialidad;
        this.contrasena = contrasena;
        this.sexo = sexo;
        this.edad = edad;
        this.telefono = telefono;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    

    
}
