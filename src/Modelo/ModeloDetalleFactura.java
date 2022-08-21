/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class ModeloDetalleFactura extends DetalleFactura {
    ConectionPg cp = new ConectionPg();
    public ModeloDetalleFactura() {
    }

    public ModeloDetalleFactura(int idetalleFactura, int idFactura, int idProducto, int Cantidad, double precio, double total) {
        super(idetalleFactura, idFactura, idProducto, Cantidad, precio, total);
    }

    public ModeloDetalleFactura(int idFactura, int idProducto, int Cantidad, double precio, double total) {
        super(idFactura, idProducto, Cantidad, precio, total);
    }

    public boolean GenerarDetalleFacturaBy() {
        try {
            String sql = "INSERT INTO public.detallefactura(\n"
                    + "	idfactura, idproducto, cantidad, precio, total)\n"
                    + "	VALUES (?, ?, ?, ?, ?);";
            PreparedStatement ps = cp.getCon().prepareStatement(sql);
            ps.setInt(1, getIdFactura());
            ps.setInt(2, getIdProducto());
            ps.setInt(3, getCantidad());
            ps.setDouble(4, getPrecio());
            ps.setDouble(5, getTotal());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDetalleFactura.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
