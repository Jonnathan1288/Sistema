/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Image;
import java.io.FileInputStream;

/**
 *
 * @author DELL
 */
public class Producto {
    private int id_producto;
    private String nombre;
    private double precio;
    private int cantidad;
    private String descripcion;
    private Image foto;
    //-----
    private FileInputStream imagen;
    private int largo;
    private String seccionProducto;

    public Producto() {
    }

    public Producto(int id_producto, String nombre, double precio, int cantidad, String descripcion, Image foto) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.foto = foto;
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

    public String getSeccionProducto() {
        return seccionProducto;
    }

    public void setSeccionProducto(String seccionProducto) {
        this.seccionProducto = seccionProducto;
    }

    
}
