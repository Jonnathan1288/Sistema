/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author DELL
 */
public class DetalleFactura {
    private int idetalleFactura;
    private int idFactura;
    private int idProducto;
    private int Cantidad;
    private double precio;
    private double total; 

    public DetalleFactura() {
    }

    public DetalleFactura(int idetalleFactura, int idFactura, int idProducto, int Cantidad, double precio, double total) {
        this.idetalleFactura = idetalleFactura;
        this.idFactura = idFactura;
        this.idProducto = idProducto;
        this.Cantidad = Cantidad;
        this.precio = precio;
        this.total = total;
    }

    public DetalleFactura(int idFactura, int idProducto, int Cantidad, double precio, double total) {
        this.idFactura = idFactura;
        this.idProducto = idProducto;
        this.Cantidad = Cantidad;
        this.precio = precio;
        this.total = total;
    }
    

    public int getIdetalleFactura() {
        return idetalleFactura;
    }

    public void setIdetalleFactura(int idetalleFactura) {
        this.idetalleFactura = idetalleFactura;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "DetalleFactura{" + "idetalleFactura=" + idetalleFactura + ", idFactura=" + idFactura + ", idProducto=" + idProducto + ", Cantidad=" + Cantidad + ", precio=" + precio + ", total=" + total + '}';
    }
    
}
