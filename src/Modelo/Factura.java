/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author DELL
 */
public class Factura {
    private int idFactura;
    private Date fecha;
    private double total;
    private String cedula; 

    public Factura() {
    }

    public Factura(int idFactura, Date fecha, double total, String cedula) {
        this.idFactura = idFactura;
        this.fecha = fecha;
        this.total = total;
        this.cedula = cedula;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
}
