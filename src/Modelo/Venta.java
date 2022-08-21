/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Image;

/**
 *
 * @author DELL
 */
public class Venta {
    private int id_producto;
    private String NombreProducto;
    private String nombre;
    private double precio;
    private int cantidad;
    private String descripcion;
    private Image foto;
    private String seccionProducto;
    private String cedula;
    private double total;
    private String apellidos;

    public Venta() {
    }

    public Venta(int id_producto, String NombreProducto, double precio, int cantidad, String cedula, double total) {
        this.id_producto = id_producto;
        this.NombreProducto = NombreProducto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.cedula = cedula;
        this.total = total;
    }
    
    
    public Venta(int id_producto, String nombre, String cedula, double total) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.cedula = cedula;
        this.total = total;
    }
    
    public Venta(int id_producto, String nombre, double precio, int cantidad, String descripcion, Image foto, String seccionProducto) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.foto = foto;
        this.seccionProducto = seccionProducto;
    }
    
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

//    public ConectionPg getCp() {
//        return cp;
//    }
//
//    public void setCp(ConectionPg cp) {
//        this.cp = cp;
//    }
    

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public String getSeccionProducto() {
        return seccionProducto;
    }

    public void setSeccionProducto(String seccionProducto) {
        this.seccionProducto = seccionProducto;
    }
    
}
