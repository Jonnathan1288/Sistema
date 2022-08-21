/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class ModeloFactura extends Factura {

    ConectionPg cp = new ConectionPg();

    public ModeloFactura() {
    }

    public ModeloFactura(int idFactura, Date fecha, double total, String cedula) {
        super(idFactura, fecha, total, cedula);
    }

    public boolean GenerarFacturaBy() {
        try {
            String sql = "INSERT INTO public.factura(\n"
                    + "	fecha, total, idpersona)\n"
                    + "	VALUES (?, ?, ?);";
            PreparedStatement ps = cp.getCon().prepareStatement(sql);
            ps.setDate(1, getFecha());
            ps.setDouble(2, getTotal());
            ps.setString(3, getCedula());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloFactura.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
