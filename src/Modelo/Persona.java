/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Image;
import java.io.FileInputStream;
import java.sql.Date;

/**
 *
 * @author DELL
 */
public class Persona {
    private String idPersona;
    private String nombres;
    private String apellidos;
    private Date fechaNacimiento;
    private String telefono;
    private String sexo;
    private double sueldo;
    private int cupo;
    private Image foto;
    //-----
    private FileInputStream imagen;
    private int largo;
    public Persona() {
    }

    public Persona(String idPersona, String nombres, String apellidos, Date fechaNacimiento, String telefono, String sexo, double sueldo, int cupo, Image foto) {
        this.idPersona = idPersona;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.sexo = sexo;
        this.sueldo = sueldo;
        this.cupo = cupo;
        this.foto = foto;
    }

   

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public FileInputStream getImagen() {
        return imagen;
    }

    public void setImagen(FileInputStream imagen) {
        this.imagen = imagen;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }
    
    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombres=" + nombres + ", apellidos=" + apellidos + ", fechaNacimiento=" + fechaNacimiento + ", telefono=" + telefono + ", sexo=" + sexo + ", sueldo=" + sueldo + ", cupo=" + cupo + '}';
    }
    
    
}
